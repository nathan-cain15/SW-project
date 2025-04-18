package components.GameOfLife;

import components.standard.Standard;

/**
 * Game of Life kernel component with primary methods.
 */
public interface GameOfLifeKernal extends Standard<GameOfLife> {

    /**
     * Executes the game of life's rules, changing the each cell to the next
     * state.
     *
     * @updates The grid
     * @ensures Applying the rules to each cell results in the new cell's state
     */
    void nextStep();

    /**
     * Flips the cell to the opposite state at a specific row and column.
     *
     * @param col
     *            The column of the cell
     * @param row
     *            The row of the cell
     * @updates the cell to the opposite state, either dead or alive
     */
    void flipCellState(int col, int row);

    /**
     * Reports whether the cell at the inputed column and row is alive or dead.
     *
     * @param col
     *            The column of the cell
     * @param row
     *            The row of the cell
     * @return Whether the cell is alive or dead
     */
    boolean cellState(int col, int row);

    /**
     * Reports the number of columns in the grid of {@this}.
     *
     * @return the numnber of columns
     */
    int numberOfColumns();

    /**
     * Reports the number of rows in the grid of {@this}.
     *
     * @return the numnber of rows
     */
    int numberOfRows();

}
