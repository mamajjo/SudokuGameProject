import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.derby.jdbc.EmbeddedDriver;


public class SudokuBoardDB {

    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String DB_URL = "jdbc:derby:SudokuBoardDB;create=true";
    SudokuBoard board;

    public SudokuBoardDB(SudokuBoard board) {
        this.board = board;
    }
    public SudokuBoardDB() {
        this.board = board;
    }

    public void saveBoard() throws ConnectionErrorException {
        try {
            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            buildSudokuBoardTable(conn);

            buildSudokuFieldTable(conn, board);

            // Close the connection.
            conn.close();
        } catch (Exception e) {
            throw new ConnectionErrorException("Error Creating the SudokuBoardTable", e);
        }
    }

    public SudokuBoard loadSudokuBoard() {
        List<SudokuField> sudokuFieldList = new ArrayList<>();
        SudokuBoard sudokuBoard = null;
        try {
            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);
            try {
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("Select * from SudokuFieldTable");
                while (rs.next()) {
                    SudokuField temp = new SudokuField(rs.getInt(2));
                    if (rs.getInt(3) == 1)
                        temp.setChangable(true);
                    else
                        temp.setChangable(false);
                    sudokuFieldList.add(temp);
                }
                sudokuBoard = new SudokuBoard(sudokuFieldList);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (sudokuBoard == null)
                throw new NullPointerException();
            else
                return sudokuBoard;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sudokuBoard;
    }

    public static void dropTables(Connection conn) {
        System.out.println("Checking for existing tables.");

        try {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try {
                // Drop the SudokuBoardTable table.
                stmt.execute("DROP TABLE SUDOKUBOARDTABLE");
                System.out.println("SudokuBoardTable table dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
            }

            try {
                // Drop the SudokuFieldTable table.
                stmt.execute("DROP TABLE SudokuFieldTable");
                System.out.println("SudokuFieldTable table dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void buildSudokuBoardTable(Connection conn) {
        try {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE SudokuBoardTable (" +
                    "Name VARCHAR(10) Not Null primary key" +
                    ")");

            // Insert row #1.
            stmt.execute("INSERT INTO SudokuBoardTable VALUES ( " +
                    "'Plansza' " + " )");


            System.out.println("SudokuBoard table created.");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void buildSudokuFieldTable(Connection conn, SudokuBoard board) {
        try {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE SudokuFieldTable" +
                    "( Ordinal_Number INT NOT NULL PRIMARY KEY, " +
                    "  Field_Value INT," +
                    "  Changeable INT," +
                    "  Board VARCHAR(10) not null references SudokuBoardTable(Name)" + " )");
            for (int i = 0; i < SudokuBoard.dimension * SudokuBoard.dimension; i++) {
                stmt.executeUpdate("INSERT INTO SudokuFieldTable VALUES" +
                        "(" + Integer.toString(i) + ", " + Integer.toString(board.getBoard().get(i).getFieldValue()) +
                        ", " + board.getBoard().get(i).changableState() + ", 'Plansza')"
                );
            }
            System.out.println("SudokuField table created.");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}