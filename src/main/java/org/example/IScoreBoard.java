package org.example;

import java.util.List;

public interface IScoreBoard {
    void startGame(String homeTeam, String awayTeam);
    void finishGame(String homeTeam, String awayTeam);
    void updateScore(String homeTeam, String awayTeam, int scoreHome, int scoreAway);
    List<Game> getSummary();
}
