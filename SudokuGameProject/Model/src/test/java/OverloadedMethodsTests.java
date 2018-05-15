import org.junit.Assert;

public class OverloadedMethodsTests {

    @org.junit.Test
    public void equalsIsReflexive() { // for the same objects should return true
        SudokuBoard b1 = new SudokuBoard();
        Assert.assertTrue(b1.equals(b1));
    }

    @org.junit.Test
    public void equalsIsSymmetric() { // y.equls(x) is true only if x.equals(y) is true
        SudokuBoard b1 = new SudokuBoard();
        SudokuBoard b2 = new SudokuBoard();
        Assert.assertTrue(b1.equals(b2) == b2.equals(b1));
    }



    @org.junit.Test
    public void equalsIsConsistent() { // consistenly retrun same value
        SudokuBoard b1 = new SudokuBoard();
        SudokuBoard b2 = new SudokuBoard();
        Assert.assertTrue(b1.equals(b2) == b1.equals(b2)); // two usages gives the same result
    }

    @org.junit.Test
    public void hashCodeIsConsistent() { //after lauching application should return the same hashcode
        SudokuBoard b2 = new SudokuBoard();
        Assert.assertTrue(b2.hashCode() == b2.hashCode());
    }

    @org.junit.Test
    public void hashCodeProducesUnequalHashCodesForUnequalInstances() { //after fail of equals should return differtt hashCodes
        SudokuBoard b1 = new SudokuBoard();
        SudokuBoard b2 = new SudokuBoard();
        Cell.resetCell();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(b1);
        Assert.assertTrue(b1.hashCode() != b2.hashCode());
    }
}
