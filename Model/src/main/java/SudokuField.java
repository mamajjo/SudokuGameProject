import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SudokuField implements Serializable, Cloneable, Comparable<SudokuField> {
    private transient IntegerProperty fieldValue = new SimpleIntegerProperty();
    //private int fieldValue;

    public SudokuField() {
        this.fieldValue.setValue(0);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(fieldValue.getValue());
    }

    public IntegerProperty fieldValueProperty() {
        return fieldValue;
    }

    //todo
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        fieldValue = new SimpleIntegerProperty();
        s.defaultReadObject();
        this.fieldValue.setValue(s.readInt());

    }

    public SudokuField(int value) {
        this.fieldValue.setValue(value);
    }

    public int getFieldValue() {
        return fieldValue.getValue();
    }

    public void setFieldValue(int fieldValue) {
        this.fieldValue.setValue(fieldValue);
    }


    @Override
    public String toString() {
        return "SudokuField{" +
                "fieldValue=" + fieldValue.getValue() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SudokuField that = (SudokuField) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(fieldValue.getValue(), that.fieldValue.getValue())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(fieldValue.getValue())
                .toHashCode();
    }

    @Override
    public int compareTo(SudokuField o) {
        if (this.getFieldValue() > o.getFieldValue())
            return 1;
        if (this.getFieldValue() < o.getFieldValue())
            return -1;
        return 0;
    }
}
