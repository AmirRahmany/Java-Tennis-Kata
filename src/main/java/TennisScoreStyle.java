import java.util.LinkedHashMap;
import java.util.Map;

public class TennisScoreStyle {
    private static final Map<Integer, String> scoreStyle = new LinkedHashMap<>();

    static {
        scoreStyle.put(0, "love");
        scoreStyle.put(1, "15");
        scoreStyle.put(2, "30");
        scoreStyle.put(3, "40");
    }

    public static String score(Integer score) {
        return scoreStyle.get(score);
    }
}
