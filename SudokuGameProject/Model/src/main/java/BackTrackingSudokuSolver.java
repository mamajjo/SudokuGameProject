import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackTrackingSudokuSolver implements SudokuSolver {

    @Override
    public boolean solve(final SudokuBoard board) {
        int ii = 0;
        if (Cell.getTerminate()) {
            return true;
        }

        if (board.getField(Cell.getRow(), Cell.getColumn()) != 0) {
            Cell.getNextCell(); // ustawienie statycznej komórki na następną obliczoną metodą geNextCell na podstawie obecnej
            return solve(board);
        }

        List<Integer> possibilities = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            possibilities.add(i);
        }

        Collections.shuffle(possibilities);

        for (int i = 0; i < possibilities.size(); i++) {
            if (board.isNumberValid(possibilities.get(i))) {
                board.setField(Cell.getRow(), Cell.getColumn(), possibilities.get(i));
            } else {
                continue;
            }
            ii++;
            //if (ii == 1000)
            Cell.getNextCell();
            boolean solved = solve(board);
            if (solved) {
                return true;
            } else {
                board.setField(Cell.getRow(), Cell.getColumn(), 0);
            }
        }
        Cell.getPreviousCell();
        return false;
    }

}
