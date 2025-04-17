/**
 * This abstract method implements the kernal methods in Game of Life, as well
 * as the Standard methods.
 */
public abstract class GameOfLifeSecondary implements GameOfLife {

    @Override
    public final String toString() {
        String s = "{ ";

        for (int i = 0; i < this.numberOfRows(); i++) {
            s = s + "{ ";
            for (int j = 0; j < this.numberOfColumns(); j++) {
                if (this.cellState(i, j)) {
                    s = s + "1, ";
                } else {
                    s = s + "0, ";
                }
            }
            s = s + "}, ";
        }

        s = s + "}";

        return s;

    }

    /**
     * Determines wether the value of {@this} and {@g} are equal.
     *
     * @param g
     *            The other GameOfLife object to which is being compared
     * @return Whether the value of {@this} and {@g} are the same or not
     */
    public final boolean equals(GameOfLife g) {
        boolean value = true;

        if (this.numberOfColumns() == g.numberOfColumns()
                && this.numberOfRows() == g.numberOfRows()
                && this.numberOfAliveCells() == g.numberOfAliveCells()) {
            for (int i = 0; i < this.numberOfRows(); i++) {
                for (int j = 0; j < this.numberOfColumns(); j++) {
                    if (this.cellState(i, j) != g.cellState(i, j)) {
                        value = false;

                        break;
                    }
                }
            }

        } else {
            value = false;
        }
        return value;
    }

    @Override
    public final void next10Steps() {
        for (int i = 0; i < 9; i++) {
            this.nextStep();
        }
    }

    @Override
    public final int numberOfAliveCells() {
        int aliveCells = 0;
        for (int i = 0; i < this.numberOfRows(); i++) {
            for (int j = 0; j < this.numberOfColumns(); j++) {
                if (this.cellState(i, j)) {
                    aliveCells++;
                }
            }
        }

        return aliveCells;
    }

    @Override
    public final void randomizeGrid() {
        for (int i = 0; i < this.numberOfRows(); i++) {
            for (int j = 0; j < this.numberOfColumns(); j++) {
                double random = Math.random();
                if (random > 0.5) {
                    this.flipCellState(i, j);
                }
            }
        }
    }

    @Override
    public final void printGrid() {
        for (int i = 0; i < this.numberOfRows(); i++) {
            for (int j = 0; j < this.numberOfColumns(); j++) {
                char state = this.cellState(i, j) ? '#' : '-';
                System.out.print(state + " ");
            }
            System.out.println();
        }
    }

}
