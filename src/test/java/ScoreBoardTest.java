import org.example.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreBoardTest {

    private ScoreBoard scoreBoard;

    @BeforeEach
    void setUp() {
        scoreBoard = new ScoreBoard();
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

        assertTrue(board.getSummary().isNull());
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
}
