public class Sudoku {
    public static void main(final String[] args) {
        SudokuBoard b1 = new SudokuBoard();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(b1);
        b1.showFieldsBoard();
        try (FileSudokuBoardDao fsbd = SudokuBoardDaoFactory.getFileDao("/Users/Maciej/Documents/Uczelnia/IVsemestr/SudokuGameProject/Model/src/main/resources/fields.txt")) {
            fsbd.write(b1);
            b1 = fsbd.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
