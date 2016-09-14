package com.tdd.playground.blackjack.domain.card;

/**
 * The enum Numeral.
 */
public enum Numeral {

    /**
     * Two numeral.
     */
    TWO("two", 2),
    /**
     * Three numeral.
     */
    THREE("three", 3),
    /**
     * Four numeral.
     */
    FOUR("four", 4),
    /**
     * Five numeral.
     */
    FIVE("five", 5),
    /**
     * Six numeral.
     */
    SIX("six", 6),
    /**
     * Seven numeral.
     */
    SEVEN("seven", 7),
    /**
     * Eight numeral.
     */
    EIGHT("eight", 8),
    /**
     * Nine numeral.
     */
    NINE("nine", 9),
    /**
     * Ten numeral.
     */
    TEN("ten", 10),
    /**
     * Jack numeral.
     */
    JACK("jack", 10),
    /**
     * Queen numeral.
     */
    QUEEN("queen", 10),
    /**
     * King numeral.
     */
    KING("king", 10),
    /**
     * Ace numeral.
     */
    ACE("ace", 11);

    private final String name;
    private final int value;

    /**
     * Instantiates a new Numeral.
     *
     * @param name  the name
     * @param value the value
     */
    Numeral(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }
}
