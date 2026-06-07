package com.tennis.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisGameTest {

    // Helper pour éviter duplication
    private TennisGame playSequence(String sequence) {
        TennisGame game = new TennisGame();
        for (char c : sequence.toCharArray()) {
            game.playPoint(c);
            if (game.isFinished()) break;
        }
        return game;
    }

    // Cas simple
    @Test
    void should_win_simple_game_for_player_A() {
        TennisGame game = playSequence("AAAA");

        assertTrue(game.isFinished());
        assertEquals("Player A", game.getWinner());
    }

    @Test
    void should_win_simple_game_for_player_B() {
        TennisGame game = playSequence("BBBB");

        assertTrue(game.isFinished());
        assertEquals("Player B", game.getWinner());
    }

    // Deuce
    @Test
    void should_reach_deuce() {
        TennisGame game = playSequence("ABABAB");

        assertEquals("Deuce", game.getScore());
        assertFalse(game.isFinished());
    }

    // Advantage
    @Test
    void should_give_advantage_to_player_A() {
        TennisGame game = playSequence("ABABABA");

        assertEquals("Advantage Player A", game.getScore());
    }

    @Test
    void should_give_advantage_to_player_B() {
        TennisGame game = playSequence("ABABABB");

        assertEquals("Advantage Player B", game.getScore());
    }

    // Retour à deuce
    @Test
    void should_return_to_deuce_after_advantage() {
        TennisGame game = playSequence("ABABABBA");

        assertEquals("Deuce", game.getScore());
    }

    // Victoire après avantage
    @Test
    void should_win_after_advantage() {
        TennisGame game = playSequence("ABABABAA");

        assertTrue(game.isFinished());
        assertEquals("Player A", game.getWinner());
    }

    // Cas réel (énoncé)
    @Test
    void should_match_example_from_kata() {
        TennisGame game = playSequence("ABABAA");

        assertTrue(game.isFinished());
        assertEquals("Player A", game.getWinner());
    }

    // Jeu long avec échanges d’avantage
    @Test
    void should_handle_long_game_with_multiple_advantages() {
        TennisGame game = playSequence("ABABABABABABABAA");

        assertTrue(game.isFinished());
        assertEquals("Player A", game.getWinner());
    }

    // Le jeu ne doit plus évoluer après victoire
    @Test
    void should_ignore_points_after_game_finished() {
        TennisGame game = playSequence("AAAA");

        game.playPoint('B'); // ignoré

        assertEquals("Player A", game.getWinner());
    }

    // Gestion des erreurs
    @Test
    void should_throw_exception_on_invalid_input() {
        TennisGame game = new TennisGame();

        assertThrows(IllegalArgumentException.class, () -> game.playPoint('X'));
    }
}