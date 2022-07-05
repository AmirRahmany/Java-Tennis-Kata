public class TennisGameStatus {
    private final Player player1;
    private final Player player2;
    private final Scoreboard scoreboard;

    public TennisGameStatus(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scoreboard = new Scoreboard();
    }

    public String getStatus() {
        String gameStatus = defaultGameStatus();

        if (player1.didWinOver(player2))
            gameStatus = matchResultFormatForPlayer1();
        else if (player2.didWinOver(player1))
            gameStatus = matchResultFormatForPlayer2();
        else if (player1.isAdvantagePoint(player2))
            gameStatus = scoreboard.advantagePointFor(player1.getName());
        else if (player2.isAdvantagePoint(player1))
            gameStatus = scoreboard.advantagePointFor(player2.getName());
        else if (player1.isDeucePoint(player2))
            gameStatus = scoreboard.deucePoint(player1.getTennisStylePoints(), player2.getTennisStylePoints());

        return gameStatus;
    }

    private String matchResultFormatForPlayer2() {
        return matchResultFormat(player2, player1);
    }

    private String matchResultFormatForPlayer1() {
        return matchResultFormat(player1, player2);
    }

    private String matchResultFormat(Player wonPlayer, Player opponent) {
        return scoreboard.matchResult(wonPlayer.getName(),
                wonPlayer.getTennisStylePoints(), opponent.getTennisStylePoints());
    }

    private String defaultGameStatus() {
        return scoreboard.setScore(player1.getTennisStylePoints(), player2.getTennisStylePoints());
    }

}
