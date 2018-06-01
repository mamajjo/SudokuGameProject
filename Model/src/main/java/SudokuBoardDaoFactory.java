public class SudokuBoardDaoFactory {

    public static FileSudokuBoardDao getFileDao(final String path) {
        return new FileSudokuBoardDao(path);
    }
    public static JdbcSudokuBoardDao getDataBaseDao(){return  new JdbcSudokuBoardDao();}
}

