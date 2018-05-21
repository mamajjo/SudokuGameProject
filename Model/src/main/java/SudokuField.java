import java.io.Serializable;

public class SudokuField implements Serializable, Cloneable, Comparable<SudokuField> {
    private int fieldValue;

    public SudokuField() {
        this.fieldValue = 0;
    }

    public SudokuField(int value) {
        this.fieldValue = value;
    }

    public int getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(int fieldValue) {
        this.fieldValue = fieldValue;
    }


    @Override
    public String toString() {
        return "SudokuField{" +
                "fieldValue=" + fieldValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SudokuField that = (SudokuField) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(fieldValue, that.fieldValue)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(fieldValue)
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
