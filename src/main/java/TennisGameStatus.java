public class TennisGameStatus {
    private static final int WINNING_SCORE = 3;
    private final Player player1;
    private final Player player2;
    private final Scoreboard scoreboard;

    public TennisGameStatus(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scoreboard = new Scoreboard();
    }

    String result(int setScorePlayer1, int setScorePlayer2) {
        String gameStatus = defaultGameStatus(setScorePlayer1, setScorePlayer2);;
        if (player1.didWinOver(player2))
            gameStatus = scoreboard.matchResult(player1, player2);
        else if (player2.didWinOver(player1))
            gameStatus = scoreboard.matchResult(player2, player1);
        else if (isAdvantagePoint(setScorePlayer1, setScorePlayer2))
            gameStatus = whichPlayerHaveAdvantagePoint(setScorePlayer1, setScorePlayer2);
        else if (isDeuce(setScorePlayer1, setScorePlayer2))
            gameStatus = "deuce";

        return gameStatus;
    }

    private String whichPlayerHaveAdvantagePoint(int player1Score, int player2Score) {
        if (player1Score - player2Score == 1)
            return scoreboard.advantagePointFor(player1.getName());

        return scoreboard.advantagePointFor(player2.getName());
    }

    private boolean isAdvantagePoint(int player1Score, int player2Score) {
        return (player1Score >= WINNING_SCORE &&
                player2Score >= (WINNING_SCORE)) &&
                player1Score - player2Score == 1 ||
                player2Score - player1Score == 1;
    }

    private boolean isDeuce(int player1Points, int player2Points) {
        return player1Points == WINNING_SCORE && player2Points == (WINNING_SCORE);
    }

    private String defaultGameStatus(int setScorePlayer1, int setScorePlayer2) {
        return scoreboard.setScore(TennisScoreStyle.score(setScorePlayer1),
                TennisScoreStyle.score(setScorePlayer2));
    }
}
