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


    boolean cellState(int col, int row);


    int numberOfColumns();


    int numberOfRows();




}
