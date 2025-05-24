package org.example;

import java.time.LocalDateTime;

public class Game {
    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;
    private final LocalDateTime startTime;

    public Game(String homeTeam, String awayTeam, LocalDateTime startTime) {
        validateGame(homeTeam, awayTeam, startTime);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.startTime = startTime;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    private static void validateGame(String homeTeam, String awayTeam, LocalDateTime startTime) {
        if (homeTeam == null || homeTeam.isBlank()|| awayTeam == null
                || awayTeam.isBlank() || startTime == null) {
            throw new IllegalArgumentException("Arguments must not be null or blank");
        }
    }

    public void updateScore(int home, int away) {
        if (home < 0 || away < 0) {
            throw new IllegalArgumentException("Score must be non-negative");
        }
        this.homeScore = home;
        this.awayScore = away;
    }

    public int numberOfGoals() {
        return homeScore + awayScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
