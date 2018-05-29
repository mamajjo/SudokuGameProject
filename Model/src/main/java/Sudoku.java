public class Sudoku {
    public static void main(final String[] args) {
        SudokuBoard b1 = new SudokuBoard();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        FileSudokuBoardDao sudokuBoardDaoFactory = SudokuBoardDaoFactory.getFileDao("/Users/Mciej/Documents/Uczelnia/IVsemestr/SudokuGameProject/Model/src/main/resources/fields.txt");
        b1 = sudokuBoardDaoFactory.read();
        solver.solve(b1);
    }
}
