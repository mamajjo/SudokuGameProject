public final class Cell {
    private static int column = 0;
    private static int row = 0;

    private static boolean terminate = false;

    private Cell(int r, int c) {
        row = r;
        column = c;
    }

    public static int getRow() {
        return row;
    }

    public static int getColumn() {
        return column;
    }

    public static void setRow(int i) {
        row = i;
    }

    public static void setColumn(int i) {
        column = i;
    }

    public static void setCell(int r, int c) {
        setRow(r);
        setColumn(c);
    }

    public static void resetCell() {
        setCell(0, 0);
        terminate = false;
    }

    public static void setTerminateTrue() {
        terminate = true;
    }

    public static boolean getTerminate() {
        return terminate;
    }

    public static void getNextCell() {
        int c = getColumn();
        int r = getRow();

        // increment column. If > 8 then becomes 0 and row is incremented
        c++;
        if (c > 8) {
            c = 0;
            r++;
        }
        // if row reaches end then row becomes 10 -> this ends an algorythm
        if (r > 8) {
            setTerminateTrue();
        }

        setCell(r, c);
    }


    public static void getPreviousCell() {
        int c = getColumn();
        int r = getRow();

        c--;
        if (c < 0) {
            c = 8;
            r--;
        }
        if (r < 0) {
            setTerminateTrue();
        }

        setCell(r, c);
    }


}
