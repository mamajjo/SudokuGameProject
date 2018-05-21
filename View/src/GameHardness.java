public enum GameHardness {
    EASY,
    MEDIUM,
    HARD;

    void setHardness(SudokuBoard board){
        switch (this){
            case EASY:
                board.zeroNumberOfFields(25);
                break;
            case MEDIUM:
                board.zeroNumberOfFields(40);
                break;
            case HARD:
                board.zeroNumberOfFields(50);
                break;
                default:
                    throw new AssertionError("Tutaj nigdy nie dojdzie");
        }
    }

}
