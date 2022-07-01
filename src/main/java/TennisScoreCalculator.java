import java.util.LinkedHashMap;
import java.util.Map;

public class TennisScoreCalculator {

    public String score(int player1points, int player2Points) {
        Map<Integer,String> styleScore = new LinkedHashMap<>();
        styleScore.put(0,"love");
        styleScore.put(1,"fifteen");
        styleScore.put(2,"thirty");
        return styleScore.get(player1points)+" vs "+ styleScore.get(player2Points);
    }
}
