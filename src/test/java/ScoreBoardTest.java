import org.example.Game;
import org.example.ScoreBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreBoardTest {

    private ScoreBoard board;

    @BeforeEach
    void setUp() {
        board = new ScoreBoard();
    }

    @Test
    void updateScore_changeGameResult() {
        board.startGame("Mexico", "Canada");
        board.updateScore("Mexico", "Canada", 0, 5);

        Game game = board.getSummary().getFirst();
        assertEquals(5, game.getAwayScore());
        assertEquals(0, game.getHomeScore());
    }

    @Test
    void finishGame_removesMatch() {
        board.startGame("Spain", "Brazil");
        board.finishGame("Spain", "Brazil");

        assertTrue(board.getSummary().isEmpty());
    }

    @Test
    void startGame_addsMatchWithZeroScore() {
        board.startGame("Mexico", "Canada");

        Game game = board.getSummary().getFirst();
        assertAll(
                () -> assertEquals("Mexico",  game.getHomeTeam()),
                () -> assertEquals("Canada",  game.getAwayTeam()),
                () -> assertEquals(0, game.getHomeScore()),
                () -> assertEquals(0, game.getAwayScore())
        );
    }

    @Test
    void getSummary_returnsSummary() {
        board.startGame("Mexico", "Canada");
        board.updateScore("Mexico", "Canada", 0, 5);

        assertAll(
                () -> assertEquals("Mexico", board.getSummary().getFirst().getHomeTeam()),
                () -> assertEquals("Canada", board.getSummary().getFirst().getAwayTeam()),
                () -> assertEquals(0, board.getSummary().getFirst().getHomeScore()),
                () -> assertEquals(5, board.getSummary().getFirst().getAwayScore())
        );
    }
}
