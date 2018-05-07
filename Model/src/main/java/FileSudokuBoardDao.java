import java.io.*;

public class FileSudokuBoardDao implements Dao<SudokuBoard>,AutoCloseable {

    public final String path;
    private ObjectOutputStream writer;
    private ObjectInputStream reader;

    public FileSudokuBoardDao(String path) {
        this.path = path;
    }

    @Override
    public SudokuBoard read() {
        SudokuBoard toReturn = new SudokuBoard();
        try {
            reader = new ObjectInputStream(new FileInputStream(path));
            toReturn = (SudokuBoard) reader.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public void write(SudokuBoard board) {
        try {
            writer = new ObjectOutputStream(new FileOutputStream(path));
            writer.writeObject(board);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if (writer != null)
            writer.close();
        if (reader != null)
            reader.close();
    }

    @Override
    protected void finalize() throws Exception {
        this.close();
    }

//    @Override
//    public SudokuBoard read() {
//        List<SudokuField> listOfFields = null;
//        try {
//            String line;
//            String[] splittedLine = new String[SudokuBoard.dimension*SudokuBoard.dimension];
//            reader = new BufferedReader(new FileReader(path));
//            while ((line = reader.readLine()) != null){
//                splittedLine = line.split(" ");
//            }
//            listOfFields = new ArrayList<SudokuField>();
//            for (int i = 0; i < splittedLine.length; i++) {
//                listOfFields.add(new SudokuField(Integer.parseInt(splittedLine[i])));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (listOfFields == null)
//            return null;
//
//        return new SudokuBoard(listOfFields);
//    }
//
//    @Override
//    public void write(SudokuBoard board) {
//        String toWrite;
//        try {
//            writer = new BufferedWriter(new FileWriter(path));
//            for (int i = 0; i < SudokuBoard.dimension; i++) {
//                for (int j = 0; j < SudokuBoard.dimension; j++) {
//                    toWrite = String.valueOf(board.getField(i,j)) + " ";
//                    writer.write(toWrite);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
