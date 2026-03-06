import java.util.ArrayList;
import java.util.List;
public class Board {

    private PlayingPiece[][] grid;
    private int size;

    public PlayingPiece[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }

    public Board(int size) {
        this.size = size;
        this.grid = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if (grid[row][column] != null) {
            return false;
        }
        grid[row][column] = playingPiece;
        return true;
    }


    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == null) {
                    Pair<Integer, Integer> rowColumn = new Pair<>(i, j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != null) {
                    System.out.print(grid[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

}

class Pair<T, U> {
    private T row;
    private U col;

    public Pair(T row, U col) {
        this.row = row;
        this.col = col;
    }

    public T getRow() {
        return row;
    }

    public U getCol() {
        return col;
    }

    public void setRow(T row) {
        this.row = row;
    }

    public void setCol(U col) {
        this.col = col;
    }
}
