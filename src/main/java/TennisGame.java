public class TennisGame {
    private final TennisGameStatus gameStatus;
    private final Player player1;
    private final Player player2;

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameStatus = new TennisGameStatus(player1, player2);
    }

    public void score(Score player1Points, Score player2Points) {
        calculatePlayersPoint(player1Points, player2Points);
    }

    private void calculatePlayersPoint(Score player1Points, Score player2Points) {
        player1.setPoints(player1Points);
        player2.setPoints(player2Points);
    }

    public String getScore() {
        return gameStatus.getStatus();
    }

    public String getPlayer1Point() {
        return player1.getTennisStylePoints();
    }

    public String getPlayer2Point() {
        return player2.getTennisStylePoints();
    }

    public boolean isWonPlayer1() {
        return player1.didWinOver(player2);
    }

    public boolean isWonPlayer2() {
        return player2.didWinOver(player1);
    }

    public int getPlayer1Score() {
        return player1.getPoints();
    }

    public int getPlayer2Score() {
        return player2.getPoints();
    }

    public boolean isDeucePoint() {
        return player1.isDeucePoint(player2);
    }

    public boolean isAdvantagePointForPlayer1() {
        return player1.isAdvantagePoint(player2);
    }

    public boolean isAdvantagePointForPlayer2() {
        return player2.isAdvantagePoint(player1);
    }
}
