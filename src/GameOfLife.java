import java.util.ArrayList;

public class GameOfLife {

    class Cell {
        int x;
        int y;

        Cell(int X, int Y) {
            this.x = X;
            this.y = Y;
        }
    }

    // representation of game
    private int cols;
    private int rows;

    // true values mean a cell in the grid is alive
    boolean[][] grid;

    GameOfLife(int Cols, int Rows) {

        this.cols = Cols;
        this.rows = Rows;
        this.grid = new boolean[this.cols][this.rows];

    }

    final void nextStep() {
        // need to change all cells simultainalously
        ArrayList<Cell> cellsToFlip = new ArrayList<>();

        // faster implementating in the future will be to keep track of live
        // cells and only check those and the surrounding cells

        // note about notation but up cell is in this case has the index of - 1 for a row

        for (int i = 0; i < this.cols; i++) {
            for (int j = 0; j < this.rows; j++) {
                int numOfLiveNeighbors = 0;

                // check if left cell is alive
                if (i - 1 >= 0 && this.grid[i - 1][j]) {
                    numOfLiveNeighbors++;
                }
                // check if right cell is alive
                if (i + 1 < this.cols && this.grid[i + 1][j]) {
                    numOfLiveNeighbors++;
                }
                // check if up cell is alive
                if (j - 1 >= 0 && this.grid[i][j - 1]) {
                    numOfLiveNeighbors++;
                }
                // check if down cell is alive
                if (j + 1 < this.rows && this.grid[i][j + 1]) {
                    numOfLiveNeighbors++;
                }
                // check if up left cell is alive
                if (i - 1 >= 0 && j - 1 >= 0 && this.grid[i - 1][j - 1]) {
                    numOfLiveNeighbors++;
                }
                // check if up right cell is alive
                if (i + 1 < this.cols && j - 1 >= 0
                        && this.grid[i + 1][j - 1]) {
                    numOfLiveNeighbors++;
                }
                // check if down left cell is alive
                if (i - 1 >= 0 && j + 1 < this.rows
                        && this.grid[i - 1][j + 1]) {
                    numOfLiveNeighbors++;
                }
                // check if down right cell is alive
                if (i + 1 < this.cols && j + 1 < this.rows
                        && this.grid[i + 1][j + 1]) {
                    numOfLiveNeighbors++;
                }

                // cell is alive
                if (this.grid[i][j]) {
                    if (numOfLiveNeighbors < 2 || numOfLiveNeighbors > 3) {
                        cellsToFlip.add(new Cell(i, j));
                    }

                    // cell is dead
                } else {
                    if (numOfLiveNeighbors == 3) {
                        cellsToFlip.add(new Cell(i, j));
                    }

                }
            }
        }

        // flip cells
        for (Cell cell : cellsToFlip) {
            this.flipCellState(cell.x, cell.y);
        }
    }

    final void printGrid() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                char state = this.grid[j][i] ? '#' : '-';
                System.out.print(state + " ");
            }
            System.out.println();
        }
    }

    final void flipCellState(int col, int row) {
        this.grid[col][row] = !this.grid[col][row];
    }

    public static void main(String[] args) {

        // creates a game and creates 3 alives cell
        // these cells flip back and form on each time step
        GameOfLife game = new GameOfLife(10, 10);

        game.flipCellState(1, 1);
        game.flipCellState(1, 2);
        game.flipCellState(1, 3);

        for (int i = 0; i < 10; i++) {
            game.printGrid();
            game.nextStep();
            System.out.println();
        }
    }
}
