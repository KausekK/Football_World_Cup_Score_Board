import org.example.Game;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    void newGame_startsWithZeroScore() {
        Game g = new Game("Mexico", "Canada", LocalDateTime.now());
        assertEquals(0, g.getHomeScore());
        assertEquals(0, g.getAwayScore());
    }

    @Test
    void updateScore_setsExactNumbers() {
        Game g = new Game("Spain", "Brazil", LocalDateTime.now());
        g.updateScore(10, 2);
        assertEquals(12, g.numberOfGoals());
    }

    @Test
    void constructor_rejectsBlankTeam() {
        assertThrows(IllegalArgumentException.class,
                () -> new Game("  ", "France", LocalDateTime.of(2025, 5, 24, 14, 30)));
    }
}
