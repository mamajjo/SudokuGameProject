import java.io.IOException;
import java.util.logging.Logger;

public class Sudoku {
    public static void main(final String[] args) {
        SudokuBoard b1 = new SudokuBoard();
        SudokuBoard b2 = new SudokuBoard();
        SudokuSolver s = new BackTrackingSudokuSolver();
        s.solve(b1);
        JdbcSudokuBoardDao jsbd = SudokuBoardDaoFactory.getDataBaseDao();
        try {
            jsbd.write(b1);
        } catch (IOException | ConnectionErrorException e) {
            e.printStackTrace();
        }
        try {
            b2 = jsbd.read();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        b2.showFieldsBoard();
        System.out.println("");
    }
}
