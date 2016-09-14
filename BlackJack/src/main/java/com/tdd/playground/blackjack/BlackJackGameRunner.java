package com.tdd.playground.blackjack;

import com.tdd.playground.blackjack.domain.player.Player;
import com.tdd.playground.blackjack.game.CardsGame;
import com.tdd.playground.blackjack.game.blackjack.BlackJackCardsGame;
import com.tdd.playground.blackjack.game.deck.DefaultShuffle;

import static java.lang.String.format;

public class BlackJackGameRunner {

    public static void main(String[] args) {

        if (args.length != 1) {

            System.out.println("Invalid Number of parameters..\n");
            System.out.println("EXAMPLE (inside jar path): java -cp blackjack-coding-test-1.0-SNAPSHOT.jar com.thomsonreuters.com.tdd.playground.blackjack.BlackJackGameRunner [number-of-players]\n");
            System.exit(1);
        } else {

            final int numberOfPlayers = Integer.parseInt(args[0]);

            CardsGame blackJack = new BlackJackCardsGame(new DefaultShuffle("Default Shuffle"), numberOfPlayers,
                    "BlackJack");

            for (int i = 0; i < numberOfPlayers; i++) {

                blackJack.addPlayer(new Player("Player " + (i + 1)));
            }

            blackJack.startGame();

            Player winner = blackJack.getWinner();

            if (winner != null) {
                System.out.println(format("Player :: %s won with :: %s and score :: %s",
                        winner.getName(), winner.getStatus(), winner.getScore()));
            } else {
                System.out.println("There was no winner this time");
            }
        }
    }
}
