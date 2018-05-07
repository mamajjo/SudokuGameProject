import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.apache.commons.collections4.list.FixedSizeList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuBoard implements Serializable {
    public static int dimension = 9;
    private List<SudokuField> sudokuFields;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("sudokuFields", sudokuFields)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuBoard that = (SudokuBoard) o;
        return Objects.equal(sudokuFields, that.sudokuFields);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sudokuFields);
    }
    //methods

    public SudokuBoard() {
        sudokuFields = Arrays.asList(new SudokuField[dimension * dimension]);
        sudokuFields = FixedSizeList.fixedSizeList(sudokuFields);
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                sudokuFields.set(j + dimension * i, new SudokuField());
            }
        }

    }

    public SudokuBoard(List<SudokuField> fromFile){
        sudokuFields = fromFile;
        sudokuFields = FixedSizeList.fixedSizeList(sudokuFields);
    }

    public SudokuBoard(SudokuBoard fromFile){
        sudokuFields = Arrays.asList(new SudokuField[dimension * dimension]);
        sudokuFields = FixedSizeList.fixedSizeList(sudokuFields);
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                sudokuFields.set(i+dimension*i, new SudokuField(fromFile.getField(i,j)));
            }
        }
    }

    public List<SudokuField> getBoard() {
        return sudokuFields;
    }

//    public SudokuField[][] getBoardCopy() { // return copy of the board
//        SudokuField[][] copyToReturn = new SudokuField[sudokuFields.length][sudokuFields.length];
//        for (int i = 0; i < sudokuFields.length; i++) {
//            for (int j = 0; j < sudokuFields.length; i++) {
//                copyToReturn[i][j].setFieldValue(getField(i, j));
//            }
//        }
//        return copyToReturn;
//    }

    public SudokuJoint getRow(int r) {
        int row = r * dimension;
        ArrayList<SudokuField> rowToReturn = new ArrayList<SudokuField>();
        for (int i = row; i < row + dimension; i++) {
            rowToReturn.add(sudokuFields.get(i));
        }
        return new SudokuJoint(rowToReturn);
    }


    public SudokuJoint getColumn(int c) {
        int column = c;
        ArrayList<SudokuField> columnToReturn = new ArrayList<SudokuField>();
        for (int i = 0; i < dimension; i++) {
            columnToReturn.add(sudokuFields.get(i * dimension + column));
        }

        return new SudokuJoint(columnToReturn);
    }

    public SudokuJoint getBox(int r, int c) {
        int row = 3 * (r / 3);
        int column = 3 * (c / 3);

        ArrayList<SudokuField> boxToReturn = new ArrayList<SudokuField>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxToReturn.add(sudokuFields.get((row + i) * dimension + column + j));
            }
        }

        return new SudokuJoint(boxToReturn);
    }

    public void showFieldsBoard() {
        int index = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (j == 3 | j == 6) {
                    System.out.print("|");
                }
                index = i * dimension + j;
                System.out.print("  " + sudokuFields.get(index).getFieldValue() + "  ");
            }
            System.out.println("");
            if (i == 2 || i == 5) {
                System.out.println("---------------------------------------------");
            }
        }
    }


    public int getField(int r, int c) {
        int index = r * dimension + c;
        return sudokuFields.get(index).getFieldValue();
    }

    public void setField(int r, int c, int number) {
        int index = r * dimension + c;
        sudokuFields.get(index).setFieldValue(number);
    }


    public boolean isNumberValid(int number) {
        return (getRow(Cell.getRow()).verifyNumber(number) &&
                getColumn(Cell.getColumn()).verifyNumber(number) &&
                getBox(Cell.getRow(), Cell.getColumn()).verifyNumber(number));

    }

    public boolean checkBoard() {
        //check all rows and columns
        for (int i = 0; i < dimension; i++) {
            if (!getRow(i).verify() || !getColumn(i).verify()) {
                return false;
            }
        }

        //check all 3x3 boxes
        for (int i = 0; i < dimension; i += 3) {
            for (int j = 0; j < dimension; j += 3) {
                if (!getBox(i, j).verify()) {
                    return false;
                }
            }
        }
        return true;
    }


}