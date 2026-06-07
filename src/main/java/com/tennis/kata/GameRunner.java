package com.tennis.kata;

public class GameRunner {

    public static void play(String sequence) {
        try {
            validateInput(sequence);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
            return;
        }

        TennisGame game = new TennisGame();

        for (char c : sequence.toCharArray()) {
            game.playPoint(c);
            System.out.println(game.getScore());

            if (game.isFinished()) break;
        }
    }

    private static void validateInput(String sequence) {
        if (sequence == null || sequence.isEmpty()) {
            throw new IllegalArgumentException("Sequence cannot be null or empty");
        }

        for (char c : sequence.toCharArray()) {
            if (c != 'A' && c != 'B') {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== TENNIS KATA ===\n");

        play("ABABAA");
    }
}