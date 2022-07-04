public class TennisGameStatus {
    private static final String DEUCE_SCORE = "deuce";
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
            gameStatus = scoreboard.matchResult(player1.getName(),
                    player1.getTennisStylePoints(), player2.getTennisStylePoints());
        else if (player2.didWinOver(player1))
            gameStatus = scoreboard.matchResult(player2.getName(),
                            player2.getTennisStylePoints(), player1.getTennisStylePoints());
        else if (player1.isAdvantagePoint(player2))
            gameStatus = scoreboard.advantagePointFor(player1.getName());
        else if (player2.isAdvantagePoint(player1))
            gameStatus = scoreboard.advantagePointFor(player2.getName());
        else if (player1.isDeucePoint(player2))
            gameStatus = scoreboard.deucePoint(player1.getTennisStylePoints(), player2.getTennisStylePoints());

        return gameStatus;
    }

    private String defaultGameStatus() {
        return scoreboard.setScore(player1.getTennisStylePoints(), player2.getTennisStylePoints());
    }

}
