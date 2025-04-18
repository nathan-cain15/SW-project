import components.GameOfLife.GameOfLife;
import components.GameOfLife.GameOfLife1;

public class RandomGameOfLife {

    public static void main(String[] args) {
        GameOfLife g = new GameOfLife1(50, 50);
        g.randomizeGrid();
        System.out.println("Randomized Grid:");
        g.printGrid();

        while (true) {
            System.out.println("Next Step:");
            g.nextStep();
            g.printGrid();
            System.out.println(" ");

            try {
                Thread.sleep(300); // Sleep for 1 second between steps
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
