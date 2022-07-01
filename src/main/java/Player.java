public class Player {
    private final String name;
    private int points = 0;

    public Player(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void incrementPoint() {
        points++;
    }

    boolean didWinOver(Player opponent) {
        return points - opponent.getPoints() >= 2 ||
               points - opponent.getPoints() >= 4;
    }
}
