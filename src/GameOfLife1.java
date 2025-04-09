import java.util.ArrayList;

/**
 * {@code GameOfLife1} is a representation of Conway's Game of Life, implemented
 * with an array of booleans to represent the grid.
 *
 * @convention <pre>
 * $this.cols >= 1  and $this.rows >= 1.
 * $this.cols matches the # of columns in $this.grid.
 * $this.rows matches the # of rows in $this.grid.
 *
 * </pre>
 * @correspondence <pre>
 * For a specific boolean in $this.grid, true is equivelent to the cell being
 * alive, while false means it is dead.
 *
 * </pre>
 */
public class GameOfLife1 extends GameOfLifeSecondary {

    /**
     * The helper class representing a cell in the grid.
     */
    private class Cell {
        /**
         * The x or column coordinate of the cell.
         */
        private int x;
        /**
         * The y or row coordinate of the cell.
         */
        private int y;

        /**
         * Cell constructor.
         *
         * @param xCoord
         *            The x or column coordinate of the cell.
         * @param yCoord
         *            The y or row coordinate of the cell.
         */
        Cell(int xCoord, int yCoord) {
            this.x = xCoord;
            this.y = yCoord;
        }
    }

    /**
     * The numer of columns in the grid.
     */
    private int cols;
    /**
     * The number of rows in the grid.
     */
    private int rows;

    /**
     * The grid containing a boolean state whether a cell is alive or not.
     */
    private boolean[][] grid;

    /**
     * Creates the initial representation.
     *
     * @param c
     *            The number of columns in the grid.
     * @param r
     *            The number or rows in the grid.
     */
    private void createNewRep(int c, int r) {
        this.cols = c;
        this.rows = r;
        this.grid = new boolean[this.cols][this.rows];
    }

    /**
     * GameOfLife1 constructor.
     *
     * @param cols
     *            The number of columns in the grid.
     * @param rows
     *            The number or rows in the grid.
     */
    GameOfLife1(int cols, int rows) {
        this.createNewRep(cols, rows);

    }

    // Standard methods

    @Override
    public final void clear() {
        this.createNewRep(this.cols, this.rows);
    }

    @Override
    public final GameOfLife newInstance() {
        return new GameOfLife1(this.cols, this.rows);

    }

    /**
     * Creates a new GameOfLife1 instance with the inputed number of columns and
     * rows.
     *
     * @param cols
     *            The number of columns in the grid.
     * @param rows
     *            The number or rows in the grid.
     * @return The new GameOfLife1 instance.
     */
    public final GameOfLife newInstance(int cols, int rows) {
        return new GameOfLife1(cols, rows);
    }

    @Override
    public final void transferFrom(GameOfLife source) {

        GameOfLife1 localSource = (GameOfLife1) source;
        this.rows = localSource.rows;
        this.cols = localSource.cols;
        this.grid = localSource.grid;

        localSource.createNewRep(this.cols, this.rows);

    }

    // Kernal Methods

    @Override
    public final void nextStep() {
        ArrayList<Cell> cellsToFlip = new ArrayList<>();

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

    @Override
    public final void flipCellState(int col, int row) {
        this.grid[col][row] = !this.grid[col][row];
    }

    @Override
    public final boolean cellState(int col, int row) {
        return this.grid[col][row];
    }

    @Override
    public final int numberOfColumns() {
        return this.cols;
    }

    @Override
    public final int numberOfRows() {
        return this.rows;
    }
}
