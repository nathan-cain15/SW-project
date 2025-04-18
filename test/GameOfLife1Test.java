
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import components.GameOfLife.GameOfLife;
import components.GameOfLife.GameOfLife1;

public class GameOfLife1Test {

    @Test
    public void testConstructor1Row1Col() {
        GameOfLife test = new GameOfLife1(1, 1);

        assertEquals(1, test.numberOfColumns());
        assertEquals(1, test.numberOfRows());
        assertEquals(0, test.numberOfAliveCells());
    }

    @Test
    public void testConstructor10Row10Col() {
        GameOfLife test = new GameOfLife1(10, 10);

        assertEquals(10, test.numberOfColumns());
        assertEquals(10, test.numberOfRows());
        assertEquals(0, test.numberOfAliveCells());
    }

    @Test
    public void testConstructor100Row100Col() {
        GameOfLife test = new GameOfLife1(100, 100);

        assertEquals(100, test.numberOfColumns());
        assertEquals(100, test.numberOfRows());
        assertEquals(0, test.numberOfAliveCells());
    }

    @Test
    public void testConstructor1000Row1000Col() {
        GameOfLife test = new GameOfLife1(1000, 1000);

        assertEquals(1000, test.numberOfColumns());
        assertEquals(1000, test.numberOfRows());
        assertEquals(0, test.numberOfAliveCells());
    }

    @Test
    public void testNewInstance100Row100Column() {
        GameOfLife test = new GameOfLife1(100, 100);
        GameOfLife test2 = test.newInstance();

        assertEquals(test.numberOfColumns(), test2.numberOfColumns());
        assertEquals(test.numberOfRows(), test2.numberOfRows());
        assertEquals(test.numberOfAliveCells(), test2.numberOfAliveCells());

        assertEquals(100, test.numberOfColumns());
        assertEquals(100, test.numberOfRows());
        assertEquals(0, test.numberOfAliveCells());

        assertNotEquals(test, test2);
    }

    @Test
    public void testClear100Row100Column() {
        GameOfLife test = new GameOfLife1(100, 100);
        test.flipCellState(0, 0);
        test.flipCellState(1, 1);
        test.flipCellState(2, 2);
        test.flipCellState(3, 3);
        test.flipCellState(4, 4);

        assertEquals(5, test.numberOfAliveCells());

        test.clear();

        assertEquals(0, test.numberOfAliveCells());
        assertEquals(100, test.numberOfColumns());
        assertEquals(100, test.numberOfRows());
    }

    @Test
    public void testTransferFrom() {
        GameOfLife test = new GameOfLife1(100, 100);
        test.flipCellState(0, 0);
        test.flipCellState(1, 1);
        test.flipCellState(2, 2);
        test.flipCellState(3, 3);
        test.flipCellState(4, 4);

        assertEquals(5, test.numberOfAliveCells());

        GameOfLife test2 = new GameOfLife1(100, 100);
        test2.transferFrom(test);

        assertEquals(5, test2.numberOfAliveCells());
        assertEquals(0, test.numberOfAliveCells());
    }

    @Test
    public void testNextStep1CellAlive() {
        GameOfLife test = new GameOfLife1(100, 100);

        test.flipCellState(50, 50);

        test.nextStep();

        assertEquals(0, test.numberOfAliveCells());

    }

    @Test
    public void testNextStep2CellsAliveNextToEachOther() {
        GameOfLife test = new GameOfLife1(100, 100);

        test.flipCellState(50, 50);
        test.flipCellState(51, 50);

        test.nextStep();

        assertEquals(0, test.numberOfAliveCells());
    }

    @Test
    public void testNextStep3CellsAliveInALine() {
        GameOfLife test = new GameOfLife1(100, 100);

        test.flipCellState(50, 50);
        test.flipCellState(51, 50);
        test.flipCellState(52, 50);

        test.nextStep();

        assertEquals(3, test.numberOfAliveCells());
        assertEquals(test.cellState(50, 50), false);
        assertEquals(test.cellState(51, 50), true);
        assertEquals(test.cellState(52, 50), false);

        assertEquals(test.cellState(51, 49), true);
        assertEquals(test.cellState(51, 51), true);

    }

    @Test
    public void testNextCell3CellsAliveSeparated() {
        GameOfLife test = new GameOfLife1(100, 100);

        test.flipCellState(50, 50);
        test.flipCellState(51, 51);
        test.flipCellState(52, 50);

        test.nextStep();

        assertEquals(1, test.numberOfAliveCells());

        assertEquals(test.cellState(51, 50), true);
    }

    @Test
    public void testNextStep4CellsAliveInSquare() {
        GameOfLife test = new GameOfLife1(100, 100);

        test.flipCellState(50, 50);
        test.flipCellState(51, 50);
        test.flipCellState(50, 51);
        test.flipCellState(51, 51);

        test.nextStep();

        assertEquals(4, test.numberOfAliveCells());

        assertEquals(test.cellState(50, 50), true);
        assertEquals(test.cellState(51, 50), true);
        assertEquals(test.cellState(50, 51), true);
        assertEquals(test.cellState(51, 51), true);

    }

    @Test
    public void testNextCell4CellsAliveInLine() {
        GameOfLife test = new GameOfLife1(100, 100);

        test.flipCellState(50, 50);
        test.flipCellState(51, 50);
        test.flipCellState(52, 50);
        test.flipCellState(53, 50);

        test.nextStep();

        assertEquals(6, test.numberOfAliveCells());

        assertEquals(test.cellState(51, 50), true);
        assertEquals(test.cellState(52, 50), true);
        assertEquals(test.cellState(51, 49), true);
        assertEquals(test.cellState(52, 49), true);
        assertEquals(test.cellState(51, 51), true);
        assertEquals(test.cellState(52, 51), true);
    }

    @Test
    public void testNextCell9CellsAlive3By3Square() {
        GameOfLife test = new GameOfLife1(100, 100);

        test.flipCellState(50, 50);
        test.flipCellState(51, 50);
        test.flipCellState(52, 50);
        test.flipCellState(50, 51);
        test.flipCellState(51, 51);
        test.flipCellState(52, 51);
        test.flipCellState(50, 52);
        test.flipCellState(51, 52);
        test.flipCellState(52, 52);

        test.nextStep();

        assertEquals(8, test.numberOfAliveCells());

        assertEquals(test.cellState(50, 50), true);
        assertEquals(test.cellState(52, 50), true);
        assertEquals(test.cellState(52, 52), true);
        assertEquals(test.cellState(52, 50), true);

        assertEquals(test.cellState(51, 49), true);
        assertEquals(test.cellState(51, 53), true);

        assertEquals(test.cellState(49, 51), true);
        assertEquals(test.cellState(53, 51), true);

    }

    @Test
    public void testFlipCellStateToAlive() {
        GameOfLife test = new GameOfLife1(100, 100);

        test.flipCellState(50, 50);

        assertEquals(test.cellState(50, 50), true);
        assertEquals(test.numberOfAliveCells(), 1);
    }

    @Test
    public void testFlipCellStateToDead() {
        GameOfLife test = new GameOfLife1(100, 100);

        test.flipCellState(50, 50);
        test.flipCellState(50, 50);

        assertEquals(test.numberOfAliveCells(), 0);
    }

    @Test
    public void testCellStateAlive() {
        GameOfLife test = new GameOfLife1(100, 100);
        GameOfLife copy = new GameOfLife1(100, 100);

        test.flipCellState(50, 50);
        copy.flipCellState(50, 50);

        assertEquals(test.cellState(50, 50), true);
        assertEquals(test, copy);
    }

    @Test
    public void testCellStateDead() {
        GameOfLife test = new GameOfLife1(100, 100);
        GameOfLife copy = new GameOfLife1(100, 100);

        assertEquals(test.cellState(50, 50), false);
        assertEquals(test, copy);
    }

    @Test
    public void testNumberOfColumns10() {
        GameOfLife test = new GameOfLife1(10, 100);
        GameOfLife copy = new GameOfLife1(10, 100);

        assertEquals(test.numberOfColumns(), 10);
        assertEquals(test, copy);
    }

    @Test
    public void testNumberOfColumns100() {
        GameOfLife test = new GameOfLife1(100, 100);
        GameOfLife copy = new GameOfLife1(100, 100);

        assertEquals(test.numberOfColumns(), 100);
        assertEquals(test, copy);
    }

    @Test
    public void testNumberOfRows10() {
        GameOfLife test = new GameOfLife1(100, 10);
        GameOfLife copy = new GameOfLife1(100, 10);

        assertEquals(test.numberOfRows(), 10);
        assertEquals(test, copy);
    }

    @Test
    public void testNumberOfRows100() {
        GameOfLife test = new GameOfLife1(100, 100);
        GameOfLife copy = new GameOfLife1(100, 100);

        assertEquals(test.numberOfRows(), 100);
        assertEquals(test, copy);
    }

    @Test
    public void testToString1() {
        GameOfLife test = new GameOfLife1(3, 3);
        GameOfLife copy = new GameOfLife1(3, 3);

        String expected = "{ { 0, 0, 0, }, " + "{ 0, 0, 0, }, "
                + "{ 0, 0, 0, }, }";

        String actual = test.toString();
        assertEquals(expected, actual);
        assertEquals(test, copy);
    }

    @Test
    public void testToString2() {
        GameOfLife test = new GameOfLife1(3, 3);
        GameOfLife copy = new GameOfLife1(3, 3);

        test.flipCellState(0, 0);
        test.flipCellState(1, 1);
        test.flipCellState(2, 2);
        String expected = "{ { 1, 0, 0, }, " + "{ 0, 1, 0, }, "
                + "{ 0, 0, 1, }, }";

        String actual = test.toString();
        assertEquals(expected, actual);
        assertEquals(test, copy);
    }

    @Test
    public void testEqualsWhenEqual() {
        GameOfLife test = new GameOfLife1(3, 3);
        GameOfLife copy = new GameOfLife1(3, 3);

        test.flipCellState(0, 0);
        test.flipCellState(1, 1);
        test.flipCellState(2, 2);

        copy.flipCellState(0, 0);
        copy.flipCellState(1, 1);
        copy.flipCellState(2, 2);

        assertEquals(test, copy);
        assertEquals(true, test.equals(copy));

    }

    @Test
    public void testEqualsWhenNotEqual() {
        GameOfLife test = new GameOfLife1(3, 3);
        GameOfLife copy = new GameOfLife1(3, 3);

        test.flipCellState(0, 0);
        test.flipCellState(1, 1);
        test.flipCellState(2, 2);

        copy.flipCellState(0, 0);
        copy.flipCellState(2, 2);

        assertNotEquals(test, copy);
        assertEquals(false, test.equals(copy));
    }

    @Test
    public void testNext10Steps1Cell() {
        GameOfLife test = new GameOfLife1(3, 3);

        test.flipCellState(1, 1);

        test.next10Steps();

        assertEquals(0, test.numberOfAliveCells());
    }

    @Test
    public void testNext10Steps2b2Square() {

        GameOfLife test = new GameOfLife1(3, 3);

        test.flipCellState(0, 0);
        test.flipCellState(0, 1);
        test.flipCellState(1, 0);
        test.flipCellState(1, 1);

        test.next10Steps();

        assertEquals(4, test.numberOfAliveCells());
    }

    @Test
    public void testNext10Steps3CellsInAline() {
        GameOfLife test = new GameOfLife1(3, 3);

        test.flipCellState(0, 0);
        test.flipCellState(0, 1);
        test.flipCellState(0, 2);

        test.next10Steps();

        assertEquals(3, test.numberOfAliveCells());

        assertEquals(true, test.cellState(0, 0));
        assertEquals(true, test.cellState(0, 1));
        assertEquals(true, test.cellState(0, 2));
    }

}
