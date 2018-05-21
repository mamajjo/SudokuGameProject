public class Sudoku {
    public static void main(final String[] args) {
        SudokuBoard b1 = new SudokuBoard();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(b1);
    }
}
