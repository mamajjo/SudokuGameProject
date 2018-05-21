import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.apache.commons.collections4.list.FixedSizeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuJoint implements Cloneable {

    private List<SudokuField> fields;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("fields", fields)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuJoint that = (SudokuJoint) o;
        return Objects.equal(fields, that.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fields);
    }

    public SudokuJoint(final List<SudokuField> joint) {
        fields = Arrays.asList(new SudokuField[joint.size()]);
        fields = FixedSizeList.fixedSizeList(fields);
        for (int i = 0; i < joint.size(); i++) {
            fields.set(i, joint.get(i));
        }
    }

    public List<SudokuField> getFields() {
        return fields;
    }

    public boolean verify() {
        List<Integer> possibilites = IntStream.rangeClosed(1, SudokuBoard.dimension).boxed().collect(Collectors.toList());
        for (int i = 0; i < SudokuBoard.dimension; i++) {
            possibilites.remove((Integer.valueOf(fields.get(i).getFieldValue())));
        }
        return possibilites.isEmpty();
    }


    public boolean verifyNumber(int number) {
        for (int i = 0; i < SudokuBoard.dimension; i++) {
            if (number == fields.get(i).getFieldValue()) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected SudokuJoint clone() throws CloneNotSupportedException {
        List<SudokuField> tempFields = Arrays.asList(new SudokuField[SudokuBoard.dimension]);
        tempFields = FixedSizeList.fixedSizeList(tempFields);
        for (int i = 0; i < tempFields.size(); i++) {
            tempFields.set(i, new SudokuField(0));
        }
        for (int i = 0; i < SudokuBoard.dimension; i++) {
            tempFields.get(i).setFieldValue(this.getFields().get(i).getFieldValue());
        }
        return new SudokuJoint(tempFields);
    }
}