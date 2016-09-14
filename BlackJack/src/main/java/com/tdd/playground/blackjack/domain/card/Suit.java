package com.tdd.playground.blackjack.domain.card;

/**
 * The enum Suit.
 */
public enum Suit {

    /**
     * Hearts suit.
     */
    HEARTS("Hearts"), /**
     * Diamonds suit.
     */
    DIAMONDS("Diamonds"), /**
     * Clubs suit.
     */
    CLUBS("Clubs"), /**
     * Spades suit.
     */
    SPADES("Spades");

    private final String name;

    /**
     * Instantiates a new Suit.
     *
     * @param name the name
     */
    Suit(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
