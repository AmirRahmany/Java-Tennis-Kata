import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisScoreCalculatorShould {

    @Test
    void accepts_two_integers_and_converts_them_to_a_tennis_style_score() {
        TennisScoreCalculator tennis = new TennisScoreCalculator();
        assertThat(tennis.score(0, 0)).isEqualTo("love vs love");
        assertThat(tennis.score(1, 1)).isEqualTo("fifteen vs fifteen");
        assertThat(tennis.score(2, 2)).isEqualTo("thirty vs thirty");
    }
}
