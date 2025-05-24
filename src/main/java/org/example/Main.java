package org.example;

public class Main {
    public static void main(String[] args) {
        ScoreBoard board = new ScoreBoard();

        board.startGame("Mexico", "Canada");
        board.updateScore("Mexico", "Canada", 0, 5);

        board.startGame("Spain", "Brazil");
        board.updateScore("Spain", "Brazil", 10, 2);

        board.startGame("Germany", "France");
        board.updateScore("Germany", "France", 2, 2);

        board.startGame("Uruguay", "Italy");
        board.updateScore("Uruguay", "Italy", 6, 6);

        board.startGame("Argentina", "Australia");
        board.updateScore("Argentina", "Australia", 3, 1);

        int place = 1;
        for (Game g : board.getSummary()) {
            System.out.println(place++ + ". " + g.getHomeTeam() + " " + g.getHomeScore() + " - " + g.getAwayTeam() + " " + g.getAwayScore());
        }

    }
}