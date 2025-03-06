/**
 * {@code GameOfLife} enhanced with secondary methods.
 */
public interface GameOfLife extends GameOfLifeKernal {

    /**
     * Jumps the state of the game of life to 10 steps forward.
     *
     * @updates The grid
     * @ensures Applying the rules to each cell over 10 iterations results in
     *          the new cell's state
     */
    void next10Steps();

    /**
     * Returns the number of alive cells on the grid.
     *
     * @return The number of alive cells
     */
    int numberOfAliveCells();

    /**
     * Flips each cell to a random state.
     *
     * @updates Each cell to a random state.
     */
    void randomizeGrid();

}
