package com.tdd.playground.blackjack.domain.card;

/**
 * This class represents the cards of the game.
 */
public class Card {

    /**
     * The Value of a card [2-11]
     */
    final Numeral value;
    /**
     * The different card suits
     */
    final Suit suit;

    /**
     * Instantiates a new Card.
     *
     * @param suit  the suit
     * @param value the value
     */
    public Card(Suit suit, Numeral value) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value.getValue();
    }

    /**
     * Gets suit.
     *
     * @return the suit
     */
    public String getSuit() {
        return suit.getName();
    }

    @Override
    public String toString() {
        return new StringBuffer().append(value).append(" of ").append(suit).toString();
    }
}
