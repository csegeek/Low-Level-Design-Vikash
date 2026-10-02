import java.util.Queue;

public class SharedResource {
 
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(Queue<Integer> sharedBuffer, int bufferSize) {
        this.sharedBuffer = sharedBuffer;
        this.bufferSize = bufferSize;
    }
    
    public synchronized void produce(int item ) throws InterruptedException{
        while (sharedBuffer.size()== bufferSize) {
            System.out.println("Buffer size is full, Producer is waiting for consumer");
            wait();
        }
        sharedBuffer.add(item);
        notify();
    }

    public synchronized int consume() throws InterruptedException{
        while (sharedBuffer.isEmpty()) {
            System.out.println("Buffer is empty, Consumer is waiting for producer");
            wait();
        }
        int item=sharedBuffer.poll();
        System.out.println("Consumed:"+item);
        notify();
        return item;
    }

    
}