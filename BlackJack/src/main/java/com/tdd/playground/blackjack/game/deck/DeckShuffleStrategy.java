package com.tdd.playground.blackjack.game.deck;

import com.tdd.playground.blackjack.domain.card.Card;

/**
 * The interface Deck shuffle strategy.
 */
public interface DeckShuffleStrategy {

    /**
     * Shuffle.
     */
    void shuffle();

    /**
     * Returns shuffle strategy.
     *
     * @return the shuffle strategy
     */
    String getShuffleStrategy();

    /**
     * Pick a card from the top of the deck.
     *
     * @return the card
     */
    Card dealCard();
}
