public class TennisScoreCalculator {

    private final Player player1;
    private final Player player2;

    public TennisScoreCalculator(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    void calculateTotalPoints(int player1Points, int player2Points) {
        if (isPlayer1WinThisSet(player1Points, player2Points))
            player1.incrementPoint();
        else if (isPlayer2WinThisSet(player1Points, player2Points))
            player2.incrementPoint();
    }

    private boolean isPlayer2WinThisSet(int player1Points, int player2Points) {
        return isPlayerWinThisSet(player2Points, player1Points);
    }

    private boolean isPlayer1WinThisSet(int player1Points, int player2Points) {
        return isPlayerWinThisSet(player1Points, player2Points);
    }

    private boolean isPlayerWinThisSet(int player1Points, int player2Points) {
        return player1Points - player2Points >= 2;
    }

}
