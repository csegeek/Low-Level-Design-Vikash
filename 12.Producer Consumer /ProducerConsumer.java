import java.util.LinkedList;

public class ProducerConsumer {

    public static void main(String[] args) {
        
        SharedResource sharedBuffer=new SharedResource(new LinkedList<>(), 3) ;
        
        Thread producerThread=new Thread(
            ()->{
                for(int i=0;i<6;i++){
                    try {
                        sharedBuffer.produce(i);
                    } 
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );

        Thread consumerThread=new Thread(
            ()->{
                 for(int i=0;i<6;i++){
                    try {
                        int item=sharedBuffer.consume();
                    } 
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );

        producerThread.start();
        consumerThread.start();
    }
    
}
