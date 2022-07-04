public enum Score {
    LOVE("love",0),
    FIFTY("15",1),
    THIRTY("30",2),
    FORTY("40",3),
    GAME("40",4);

    private final String toDigit;

    private final int toInteger;

    Score(String toDigit, int toInteger) {
        this.toDigit = toDigit;
        this.toInteger = toInteger;
    }

    public String toDigit() {
        return toDigit;
    }

    public int toInteger() {
        return toInteger;
    }
}
