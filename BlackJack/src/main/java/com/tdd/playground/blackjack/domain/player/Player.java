package com.tdd.playground.blackjack.domain.player;

import com.tdd.playground.blackjack.domain.card.Card;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

/**
 * The class Player.
 */
public class Player {

    private final String name;
    private List<Card> cards;
    private int score;

    /**
     * Instantiates a new Player.
     *
     * @param name the name
     */
    public Player(String name) {

        cards = new ArrayList<>();
        this.name = name;
    }

    /**
     * Add card.
     *
     * @param card the card
     */
    public void addCard(Card card) {

        System.out.println(format("Adding card :: %s to Player :: %s", card.toString(), getName()));

        cards.add(card);

        score += card.getValue();
    }

    /**
     * Gets cards.
     *
     * @return the cards
     */
    public List<Card> getCards() {

        return cards;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {

        return score;
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
     * Gets status.
     *
     * @return the status
     */
    public PlayerStatus getStatus() {

        if (score < 17) {

            return PlayerStatus.HIT;
        } else if (score >= 17 && score < 21) {

            return PlayerStatus.STICK;
        } else if (score == 21) {

            return PlayerStatus.BLACKJACK;
        } else {

            return PlayerStatus.BUSTED;
        }
    }
}
