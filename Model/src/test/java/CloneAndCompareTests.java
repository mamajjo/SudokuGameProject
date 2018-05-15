import org.junit.Assert;

public class CloneTests {

    @org.junit.Test
    public void isCopiedBoardIsTheSameAsSourceBoard_sholdBeEqual() { // for the same objects should return true
        SudokuBoard expectedBoard = new SudokuBoard();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(expectedBoard);
        SudokuBoard cloneBoard = new SudokuBoard();
        try {
            cloneBoard = (SudokuBoard) expectedBoard.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expectedBoard, cloneBoard);
    }
    @org.junit.Test
    public void isChangedBoardIsTheSameAsSourceBoard_shouldBeUnequal() { // for the same objects should return true
        SudokuBoard expectedBoard = new SudokuBoard();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(expectedBoard);
        SudokuBoard cloneBoard = new SudokuBoard();
        try {
            cloneBoard = (SudokuBoard) expectedBoard.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (expectedBoard.getField(1,1) == 1) cloneBoard.setField(1,1, 2);
        else cloneBoard.setField(1,1,1);
        Assert.assertNotEquals(expectedBoard, cloneBoard);
    }
    @org.junit.Test
    public void isJointCopiedCorrectly_shouldBeEqual(){
        SudokuBoard expectedBoard = new SudokuBoard();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(expectedBoard);
        SudokuJoint expectedJoint = new SudokuJoint(expectedBoard.getBox(1,1).getFields());
        try {
            Assert.assertEquals(expectedJoint, expectedBoard.getBox(1,1).clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void compareTwoFields_ifFirstIsBigger_shouldBeOk(){
        SudokuBoard b1 = new SudokuBoard();
        b1.setField(0,0,1);
        b1.setField(0,1,2);
        Assert.assertTrue(b1.getBoard().get(1).compareTo(b1.getBoard().get(0)) == 1 );
    }



}
