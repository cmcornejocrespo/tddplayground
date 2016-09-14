package com.tdd.playground.blackjack.game;

import com.tdd.playground.blackjack.domain.player.Player;

/**
 * The interface CardsGame.
 */
public interface CardsGame {

    /**
     * Gets game name.
     *
     * @return the game name
     */
    String getGameName();

    /**
     * Add player.
     *
     * @param player the player
     */
    void addPlayer(Player player);

    /**
     * Start game.
     */
    void startGame();

    /**
     * Gets winner.
     *
     * @return the winner
     */
    Player getWinner();
}
