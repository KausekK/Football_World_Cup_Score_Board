package org.example;

import java.time.LocalDateTime;
import java.util.*;

public class ScoreBoard implements IScoreBoard {

    private record MatchKey(String home, String away) {
        MatchKey {
            home = home.strip().toUpperCase();
            away = away.strip().toUpperCase();
        }
    }

    private final Map<MatchKey, Game> games = new HashMap<>();

    @Override
    public void startGame(String homeTeam, String awayTeam) {
        validateTeams(homeTeam, awayTeam);

        MatchKey key = new MatchKey(homeTeam, awayTeam);

        if (games.containsKey(key)) {
            throw new IllegalStateException(" Match already has started");
        }
        games.put(key, new Game(homeTeam, awayTeam, LocalDateTime.now()));
    }

    @Override
    public void finishGame(String homeTeam, String awayTeam) {
        MatchKey key = new MatchKey(homeTeam, awayTeam);
        if (games.containsKey(key)) {
            games.remove(key);
        } else {
            throw new NoSuchElementException(" Match not found");
        }
    }

    @Override
    public void updateScore(String homeTeam, String awayTeam, int scoreHome, int scoreAway) {
        MatchKey key = new MatchKey(homeTeam, awayTeam);
        if (games.containsKey(key)) {
            Game game = games.get(key);
            game.updateScore(scoreHome, scoreAway);
        } else {
            throw new NoSuchElementException(" Match does not exist");
        }
    }

    @Override
    public List<Game> getSummary() {
        return games.values().stream()
                .sorted(Comparator.comparingInt(Game::numberOfGoals)
                        .thenComparing(Game::getStartTime).reversed())
                .toList();
    }

    private static void validateTeams(String home, String away) {
        if (home == null || away == null || home.isBlank() || away.isBlank()) {
            throw new IllegalArgumentException("Team names must be non-blank");
        }
        if (home.strip().equalsIgnoreCase(away.strip())) {
            throw new IllegalArgumentException("A team cannot play against itself");
        }
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "games=" + games +
                '}';
    }
}
