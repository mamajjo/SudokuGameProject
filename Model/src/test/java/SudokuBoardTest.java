import org.junit.Assert;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

public class SudokuBoardTest {


    @org.junit.Test
    public void checkIfTwoSolutionsAreSolved_ShouldBeDifferent() {
        SudokuBoard b1 = new SudokuBoard();
        SudokuBoard b2 = new SudokuBoard();
        Cell.resetCell();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        boolean solved1 = solver.solve(b1);
        Cell.resetCell();
        boolean solved2 = solver.solve(b2);
        Assert.assertTrue(solved1);
        Assert.assertTrue(solved2);
        Assert.assertThat(b1.getBoard(), not(equalTo(b2.getBoard())));
    }

    @org.junit.Test
    public void checkIfCellIsTerminated_ShouldBeTrue() {
        SudokuBoard b1 = new SudokuBoard();
        Cell.resetCell();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        boolean solved1 = solver.solve(b1);
        Assert.assertTrue(Cell.getTerminate());
    }


    @org.junit.Test
    public void setTwoCellsWithSameNumber_checkBoardShouldFail() {
        SudokuBoard b1 = new SudokuBoard();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        Cell.resetCell();
        boolean solved = solver.solve(b1);
        b1.setField(1, 1, 1);
        b1.setField(1, 3, 1);
        Assert.assertFalse(b1.checkBoard());
    }

    @org.junit.Test
    public void checkBoard_shouldPass() {
        SudokuBoard b1 = new SudokuBoard();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        Cell.resetCell();
        boolean solved = solver.solve(b1);
        Assert.assertTrue(solved);
    }

    @org.junit.Test
    public void checksIfSetWorks_checkShouldBePassed() {
        SudokuBoard b1 = new SudokuBoard();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        Cell.resetCell();
        boolean solved = solver.solve(b1);
        b1.setField(1, 1, 1);
        Assert.assertEquals(b1.getField(1, 1), 1);
    }

}