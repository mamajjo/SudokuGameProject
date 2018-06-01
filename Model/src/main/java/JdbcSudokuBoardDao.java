import java.io.IOException;
import java.sql.*;

public class JdbcSudokuBoardDao implements AutoCloseable, Dao<SudokuBoard>
{
    SudokuBoardDB db;
    @Override
    public void close() throws Exception {

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public SudokuBoard read() throws ClassNotFoundException, IOException {
        //todo
        db = new SudokuBoardDB();
        // odczytanie z bazy danych poprzedniego stano
        return db.loadSudokuBoard();
    }

    @Override
    public void write(SudokuBoard sthToWrite) throws IOException, ConnectionErrorException {
        db = new SudokuBoardDB(sthToWrite);
        db.saveBoard();
// usunięcie obecnego stanu i wpisanie zupełnie nowego
    }
}
