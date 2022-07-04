public class Player {
    private static final int WINNING_SCORE = 4;
    private final String name;

    private Score points;

    public Player(String name) {
        this.name = name;
    }

    public void setPoints(Score points) {
        this.points = points;
    }

    public int getPoints() {
        return points.toInteger();
    }

    public String getTennisStylePoints() {
        return points.toDigit();
    }

    public String getName() {
        return name;
    }

    boolean didWinOver(Player opponent) {
        return points.toInteger() >= WINNING_SCORE &&
                hasAtLeastTwoPointsDifferenceFromAnOpponent(opponent);
    }

    private boolean hasAtLeastTwoPointsDifferenceFromAnOpponent(Player opponent) {
        return points.toInteger() - opponent.getPoints() >= 2;
    }

    public boolean isDeucePoint(Player opponent) {
        return hasAtLeastThreePoints() && isEqualPoints(opponent);
    }

    private boolean isEqualPoints(Player opponent) {
        return points.toInteger() == opponent.getPoints();
    }

    public boolean isAdvantagePoint(Player player2) {
        return hasAtLeastThreePoints() && hasOneMorePointThanHisOpponent(player2);
    }

    private boolean hasAtLeastThreePoints() {
        return points.toInteger() >= 3;
    }

    private boolean hasOneMorePointThanHisOpponent(Player player2) {
        return points.toInteger() - player2.getPoints() == 1;
    }
}
