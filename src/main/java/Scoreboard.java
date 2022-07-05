public class Scoreboard {

    public String matchResult(String wonPlayerName, String player1Points, String player2Points) {
        return String.format("%s scored a %s-%s victory", wonPlayerName, player1Points, player2Points);
    }

    String setScore(String player1Points, String player2Points) {
        return String.format("%s-%s", player1Points, player2Points);
    }

    String advantagePointFor(String playerName) {
        return String.format("Advantage point for %s", playerName);
    }

    public String deucePoint(String player1Points, String player2Points) {
        return String.format("Battle To %s-%s", player1Points, player2Points);
    }
}
