package com.tdd.playground.blackjack.game.deck;


import com.tdd.playground.blackjack.domain.card.Card;
import com.tdd.playground.blackjack.domain.card.Numeral;
import com.tdd.playground.blackjack.domain.card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.String.format;

public class DefaultShuffle implements DeckShuffleStrategy {

    private final String shuffleStrategy;
    private List<Card> deck;

    public DefaultShuffle(String shuffleStrategy) {

        this.shuffleStrategy = shuffleStrategy;

        deck = new ArrayList<>();

        for (Suit s : Suit.values()) {
            for (Numeral n : Numeral.values()) {
                deck.add(new Card(s, n));
            }
        }
    }

    @Override
    public void shuffle() {

        System.out.println(format("Shuffling deck using %s", getShuffleStrategy()));

        long seed = System.nanoTime();

        //simple shuffle strategy
        Collections.shuffle(deck, new Random(seed));
    }

    @Override
    public String getShuffleStrategy() {

        return shuffleStrategy;
    }

    @Override
    public Card dealCard() {

        return deck.remove(deck.size() - 1);
    }
}
