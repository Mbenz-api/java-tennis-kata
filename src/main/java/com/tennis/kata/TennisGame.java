package com.tennis.kata;

public class TennisGame {

    private int scoreA = 0;
    private int scoreB = 0;
    private boolean finished = false;
    private String winner = null;

    private static final String[] POINTS = {"0", "15", "30", "40"};

    public void playPoint(char player) {
        if (finished) return;

        if (player == 'A') {
            scoreA++;
        } else if (player == 'B') {
            scoreB++;
        } else {
            throw new IllegalArgumentException("Invalid player: " + player);
        }

        updateGameState();
    }

    public String getScore() {
        if (finished) {
            return winner + " wins the game";
        }

        if (isDeuce()) {
            if (scoreA == scoreB) return "Deuce";
            if (scoreA > scoreB) return "Advantage Player A";
            return "Advantage Player B";
        }

        return "Player A : " + pointToString(scoreA)
                + " / Player B : " + pointToString(scoreB);
    }

    public boolean isFinished() {
        return finished;
    }

    public String getWinner() {
        return winner;
    }

    // ===== Private logic =====

    private void updateGameState() {
        if (hasWon(scoreA, scoreB)) {
            finished = true;
            winner = "Player A";
        } else if (hasWon(scoreB, scoreA)) {
            finished = true;
            winner = "Player B";
        }
    }

    private boolean hasWon(int player, int opponent) {
        return player >= 4 && player - opponent >= 2;
    }

    private boolean isDeuce() {
        return scoreA >= 3 && scoreB >= 3;
    }

    private String pointToString(int points) {
        return POINTS[Math.min(points, 3)];
    }


}