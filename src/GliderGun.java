import components.GameOfLife.GameOfLife;
import components.GameOfLife.GameOfLife1;

public class GliderGun {

    public static void main(String[] args) {
        GameOfLife g = new GameOfLife1(50, 30);

        // left square
        g.flipCellState(1, 10);
        g.flipCellState(1, 11);
        g.flipCellState(2, 10);
        g.flipCellState(2, 11);

        // middle shape
        g.flipCellState(11, 10);
        g.flipCellState(11, 11);
        g.flipCellState(11, 12);

        g.flipCellState(12, 9);
        g.flipCellState(13, 8);
        g.flipCellState(14, 8);

        g.flipCellState(12, 13);
        g.flipCellState(13, 14);
        g.flipCellState(14, 14);

        g.flipCellState(15, 11);

        g.flipCellState(16, 9);
        g.flipCellState(16, 13);

        g.flipCellState(17, 10);
        g.flipCellState(17, 11);
        g.flipCellState(17, 12);

        g.flipCellState(18, 11);

        //right shape
        g.flipCellState(21, 10);
        g.flipCellState(21, 9);
        g.flipCellState(21, 8);
        g.flipCellState(22, 10);
        g.flipCellState(22, 9);
        g.flipCellState(22, 8);

        g.flipCellState(23, 7);
        g.flipCellState(23, 11);

        g.flipCellState(25, 7);
        g.flipCellState(25, 6);
        g.flipCellState(25, 11);
        g.flipCellState(25, 12);

        //right square
        g.flipCellState(35, 8);
        g.flipCellState(35, 9);
        g.flipCellState(36, 8);
        g.flipCellState(36, 9);

        while (true) {
            System.out.println("Next Step:");
            g.printGrid();

            System.out.println("");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            g.nextStep();
        }

    }

}
