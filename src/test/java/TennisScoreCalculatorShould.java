import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TennisScoreCalculatorShould {
    private TennisGame tennis;

    @BeforeEach
    void setUp() {
        tennis = new TennisGame(new Player("player1"), new Player("player2"));
    }

    @Test
    void accepts_two_integers_and_converts_them_to_a_tennis_style_score() {
        assertThat(tennis.score(0, 0)).isEqualTo("love-love");
        assertThat(tennis.score(1, 1)).isEqualTo("15-15");
        assertThat(tennis.score(2, 2)).isEqualTo("30-30");
        assertThat(tennis.score(0, 3)).isEqualTo("love-40");
    }

    @Test
    void throw_exception_when_the_score_is_not_valid() {
        assertThatExceptionOfType(TennisScoreException.class)
                .isThrownBy(() -> tennis.score(-1, 3));
    }

    @Test
    void first_player_is_won_which_to_have_won_at_least_four_points_in_total_and_at_two_points_more_than_opponent() {
        tennis.score(3, 1);
        tennis.score(1, 3);
        tennis.score(3, 1);
        assertThat(tennis.score(3, 1)).isEqualTo("player1 scored a 3-1 victory");
    }

    @Test
    void player2_is_won() {
        tennis.score(1, 3);
        tennis.score(1, 3);
        tennis.score(1, 3);
        assertThat(tennis.score(3, 1)).isEqualTo("player2 scored a 3-1 victory");
    }

    @Test
    void score_is_deuce_if_at_least_three_points_have_been_scored_by_each_player_and_the_scores_are_equal() {
        assertThat(tennis.score(3, 3)).isEqualTo("deuce");
    }

    @Test
    void score_is_advantage_if_at_least_three_points_have_been_scored_by_each_player_and_the_scores_are_equal() {
        assertThat(tennis.score(4, 3)).isEqualTo("advantage point for player1");
        assertThat(tennis.score(4, 5)).isEqualTo("advantage point for player2");
    }
}
