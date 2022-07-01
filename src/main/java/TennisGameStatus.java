public class TennisGameStatus {
    private static final int WINNING_SCORE = 3;
    private static final String DEUCE_SCORE = "deuce";
    private final Player player1;
    private final Player player2;
    private final Scoreboard scoreboard;

    public TennisGameStatus(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scoreboard = new Scoreboard();
    }

    String result(int setScorePlayer1, int setScorePlayer2) {
        String gameStatus = defaultGameStatus(setScorePlayer1, setScorePlayer2);

        if (player1.didWinOver(player2))
            gameStatus = scoreboard.matchResult(player1, player2);
        else if (player2.didWinOver(player1))
            gameStatus = scoreboard.matchResult(player2, player1);
        else if (isAdvantagePoint(setScorePlayer1, setScorePlayer2))
            gameStatus = whichPlayerHasAdvantagePoint(setScorePlayer1, setScorePlayer2);
        else if (isDeuce(setScorePlayer1, setScorePlayer2))
            gameStatus = DEUCE_SCORE;

        return gameStatus;
    }

    private String whichPlayerHasAdvantagePoint(int player1Score, int player2Score) {
        if (hasOneMorePointThanHisOpponent(player1Score, player2Score))
            return scoreboard.advantagePointFor(player1.getName());

        return scoreboard.advantagePointFor(player2.getName());
    }

    private boolean isAdvantagePoint(int player1Score, int player2Score) {
        return haveLeastThreePointsBeenScoredByEachPlayer(player1Score, player2Score) &&
                hasPlayerOneMorePointThanHisOpponent(player1Score, player2Score);
    }

    private boolean haveLeastThreePointsBeenScoredByEachPlayer(int player1Score, int player2Score) {
        return haveLeastThreePoints(player1Score) && haveLeastThreePoints(player2Score);
    }

    private boolean hasPlayerOneMorePointThanHisOpponent(int player1Score, int player2Score) {
        return hasOneMorePointThanHisOpponent(player1Score, player2Score) ||
                hasOneMorePointThanHisOpponent(player2Score, player1Score);
    }

    private boolean hasOneMorePointThanHisOpponent(int playerPoint, int opponentPoint) {
        return playerPoint - opponentPoint == 1;
    }

    private boolean isDeuce(int player1Points, int player2Points) {
        return haveLeastThreePoints(player1Points) && player1Points == player2Points;
    }

    private boolean haveLeastThreePoints(int playerPoint) {
        return playerPoint >= WINNING_SCORE;
    }

    private String defaultGameStatus(int setScorePlayer1, int setScorePlayer2) {
        return scoreboard.setScore(TennisScoreStyle.score(setScorePlayer1),
                TennisScoreStyle.score(setScorePlayer2));
    }
}
