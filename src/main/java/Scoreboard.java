public class Scoreboard {

    public String matchResult(Player won, Player opponent) {
        return String.format("%s scored a %d-%d victory", won.getName(), won.getPoints(), opponent.getPoints());
    }

    String setScore(String player1Points, String player2Points) {
        return String.format("%s-%s",player1Points ,player2Points );
    }

    String advantagePointFor(String player) {
        return String.format("advantage point for %s",player);
    }
}
