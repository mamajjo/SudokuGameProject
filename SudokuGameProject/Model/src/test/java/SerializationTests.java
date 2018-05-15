import org.junit.Assert;

public class SerializationTests {

    @org.junit.Test
    public void CheckIfDeserializedBoardIsTheSame_ShouldBeOk() {
        SudokuBoard expectedBoard = new SudokuBoard();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(expectedBoard);
        SudokuBoard actualBoard = new SudokuBoard();
        try (FileSudokuBoardDao fsbd = SudokuBoardDaoFactory.getFileDao("/Users/Maciej/Documents/Uczelnia/IVsemestr/SudokuGameProject/Model/src/main/resources/fields.txt")) {
            fsbd.write(expectedBoard);
            actualBoard = fsbd.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expectedBoard, actualBoard);
    }

}
