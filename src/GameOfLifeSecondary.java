public abstract class GameOfLifeSecondary implements GameOfLife {

    @Override
    public String toString() {
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

    public boolean equals(GameOfLife g) {
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
    public void next10Steps() {
        for (int i = 0; i < 9; i++) {
            this.nextStep();
        }
    }

    @Override
    public int numberOfAliveCells() {
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
    public void randomizeGrid() {
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
    public void printGrid() {
        for (int i = 0; i < this.numberOfRows(); i++) {
            for (int j = 0; j < this.numberOfColumns(); j++) {
                char state = this.cellState(i, j) ? '#' : '-';
                System.out.print(state + " ");
            }
            System.out.println();
        }
    }

}
