public class TennisGame {
    private final TennisScoreCalculator scoreCalculator;
    private final TennisGameStatus gameStatus;

    public TennisGame(Player player1, Player player2) {
        this.scoreCalculator = new TennisScoreCalculator(player1,player2);
        this.gameStatus = new TennisGameStatus(player1, player2);
    }

    public String score(int player1Points, int player2Points) {
        if (isValidPoints(player1Points, player2Points))
            throw new TennisScoreException();

        scoreCalculator.calculateTotalPoints(player1Points, player2Points);

        return gameStatus.result(player1Points, player2Points);
    }

   private boolean isValidPoints(int player1Points, int player2Points) {
        return player1Points < 0 || player2Points < 0;
    }
}
