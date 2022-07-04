import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TennisGameShould {
    private TennisGame tennis;

    @BeforeEach
    void setUp() {
        tennis = new TennisGame(new Player("player1"), new Player("player2"));
    }

    @Test
    void accepts_two_integers_and_converts_them_to_a_tennis_style_score() {
        tennis.score(Score.LOVE, Score.LOVE);

        assertThat(tennis.getPlayer1Point()).isEqualTo("love");
        assertThat(tennis.getPlayer2Point()).isEqualTo("love");

        tennis.score(Score.FIFTY, Score.FIFTY);

        assertThat(tennis.getPlayer1Point()).isEqualTo("15");
        assertThat(tennis.getPlayer2Point()).isEqualTo("15");

        tennis.score(Score.FIFTY, Score.THIRTY);

        assertThat(tennis.getPlayer1Point()).isEqualTo("15");
        assertThat(tennis.getPlayer2Point()).isEqualTo("30");

        tennis.score(Score.LOVE, Score.FORTY);

        assertThat(tennis.getPlayer1Point()).isEqualTo("love");
        assertThat(tennis.getPlayer2Point()).isEqualTo("40");
    }

    @Test
    void first_player_is_won_which_to_have_won_at_least_four_points_in_total_and_at_two_points_more_than_opponent() {
        tennis.score(Score.GAME, Score.FIFTY);

        assertThat(tennis.isWonPlayer1()).isTrue();
        assertThat(tennis.isWonPlayer2()).isFalse();

        tennis.score(Score.FIFTY, Score.GAME);

        assertThat(tennis.isWonPlayer2()).isTrue();
        assertThat(tennis.getPlayer1Score()).isEqualTo(1);
        assertThat(tennis.getPlayer2Score()).isEqualTo(4);
    }

    @Test
    void score_is_deuce_if_at_least_three_points_have_been_scored_by_each_player_and_the_scores_are_equal() {
        tennis.score(Score.FORTY, Score.FORTY);
        assertThat(tennis.isDeucePoint()).isTrue();
    }

    @Test
    void score_is_advantage_if_at_least_three_points_have_been_scored_by_each_player_and_the_scores_are_equal() {
        tennis.score(Score.GAME, Score.FORTY);

        assertThat(tennis.isAdvantagePointForPlayer1()).isTrue();
        assertThat(tennis.isAdvantagePointForPlayer2()).isFalse();

        tennis.score(Score.FORTY, Score.GAME);

        assertThat(tennis.isAdvantagePointForPlayer1()).isFalse();
        assertThat(tennis.isAdvantagePointForPlayer2()).isTrue();
    }

    @Test
    void get_score_format() {
        tennis.score(Score.FIFTY, Score.GAME);
        assertThat(tennis.getScore()).isEqualTo("player2 scored a 40-15 victory");

        tennis.score(Score.FORTY, Score.FORTY);
        assertThat(tennis.getScore()).isEqualTo("Battle To 40-40");

        tennis.score(Score.GAME, Score.FORTY);
        assertThat(tennis.getScore()).isEqualTo("Advantage point for player1");
    }
}
