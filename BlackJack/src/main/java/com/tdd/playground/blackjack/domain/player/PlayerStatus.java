package com.tdd.playground.blackjack.domain.player;

/**
 * The enum Player status.
 */
public enum PlayerStatus {

    /**
     * Hit player status.
     */
    HIT("Hit"), /**
     * Stick player status.
     */
    STICK("Stick"), /**
     * Busted player status.
     */
    BUSTED("Busted"), /**
     * Blackjack player status.
     */
    BLACKJACK("BlackJack");

    private final String name;

    /**
     * Instantiates a new Player status.
     *
     * @param name the name
     */
    PlayerStatus(String name) {
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
