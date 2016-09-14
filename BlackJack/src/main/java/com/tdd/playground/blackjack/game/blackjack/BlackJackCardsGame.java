package com.tdd.playground.blackjack.game.blackjack;

import com.tdd.playground.blackjack.domain.player.Player;
import com.tdd.playground.blackjack.domain.player.PlayerStatus;
import com.tdd.playground.blackjack.game.CardsGame;
import com.tdd.playground.blackjack.game.deck.DeckShuffleStrategy;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

/**
 * MVP of BlackJack game.
 * Time spent 2.5h.
 * <p/>
 * <p>My implementation is up to step 4, but will easily support different shuffle implementation that implements
 * DeckShuffleStrategy (i.e new BlackJackCardsGame(new PharoahShuffler(), "any name")) via a input parameter lookup</p>
 * <p/>
 * <p>In terms of Step 6 we could make a little refactoring to support List<GameRule>. Each of those GameRule's
 * could implements an interface which API it's something like <tt>boolean isRuleSatisfied()</tt>. An example of these rules
 * implementation can be found on any of the private methods inside this class<tt>anyPlayerIsBlackJack(),
 * allBusted(),allPlayersStickInAround, etc</tt> </></p>
 * <p/>
 * <p>Just to quickly mention that the main runner is very light-weighted and can be improve to deal with
 * unexpected parameters</p>
 *
 * @author Carlos M. Cornejo
 */
public class BlackJackCardsGame implements CardsGame {

    private static final int
            DEFAULT_BLACKJACK_PLAYERS = 3,
            MIN_BLACKJACK_PLAYERS = 2,
            MAX_BLACKJACK_PLAYERS = 6;

    private final DeckShuffleStrategy dealer;
    private final String name;
    private List<Player> players;

    public BlackJackCardsGame(DeckShuffleStrategy dealer, String name) {

        this.dealer = dealer;
        this.name = name;
        players = new ArrayList<>(DEFAULT_BLACKJACK_PLAYERS);

        System.out.println(format("Number of players : %s", DEFAULT_BLACKJACK_PLAYERS));
    }

    public BlackJackCardsGame(DeckShuffleStrategy dealer, int numberOfPlayers, String name) {

        if (numberOfPlayers < MIN_BLACKJACK_PLAYERS || numberOfPlayers > MAX_BLACKJACK_PLAYERS) {
            throw new IllegalArgumentException("BlackJack game oly allows players between [2-6]");
        }

        this.dealer = dealer;
        this.name = name;
        players = new ArrayList<>(numberOfPlayers);

        System.out.println(format("Number of players : %s", numberOfPlayers));
    }

    @Override
    public void addPlayer(Player player) {

        showMessage("%s has joined the game..", player.getName());
        this.players.add(player);
    }

    @Override
    public void startGame() {

        //initial shuffle
        dealer.shuffle();

        //initial game messages
        showMessage("Welcome to %s game", getGameName());
        showMessage("You have chosen to play the game with %s players", players.size());

        //dealing first hand
        firstHand();

        while (!isGameFinished()) {

            for (Player player : players) {

                final PlayerStatus playerStatus = player.getStatus();

                if (playerStatus == PlayerStatus.HIT) {

                    player.addCard(dealer.dealCard());
                }
            }
        }
    }

    @Override
    public Player getWinner() {

        Player winner = null;
        final Player firstBlackPlayer = getFirstBlackPlayer();

        if (firstBlackPlayer != null) {

            winner = firstBlackPlayer;
        } else if (getPlayerCloserToBlackJack() != null) {

            winner = getPlayerCloserToBlackJack();
        }
        return winner;
    }

    @Override
    public String getGameName() {

        return name;
    }

    private void firstHand() {

        showMessage("Dealing a first hand of two cards...");

        for (Player player : players) {

            player.addCard(dealer.dealCard());
            player.addCard(dealer.dealCard());
        }
    }

    private boolean isGameFinished() {

        return anyPlayerIsBlackJack() || allBusted() || allPlayersStickInAround();
    }

    private boolean anyPlayerIsBlackJack() {

        boolean isPlayerBlackJack = false;

        for (Player player : players) {

            if (player.getStatus().equals(PlayerStatus.BLACKJACK)) {

                isPlayerBlackJack = true;
                break;
            }
        }

        return isPlayerBlackJack;
    }

    private boolean allBusted() {

        int bustedPlayers = 0;

        for (Player player : players) {

            if (player.getStatus().equals(PlayerStatus.BUSTED))

                bustedPlayers++;
        }

        return bustedPlayers == players.size();
    }

    private boolean allPlayersStickInAround() {

        int playersStickInAround = 0;
        int playersHitInAround = 0;

        for (Player player : players) {

            final PlayerStatus playerStatus = player.getStatus();

            if (playerStatus.equals(PlayerStatus.STICK)) {

                playersStickInAround++;
            } else if (playerStatus.equals(PlayerStatus.HIT)) {

                playersHitInAround++;
            }
        }

        //all players stick or there are players stick but no on hit
        return (playersStickInAround == players.size()) || (playersStickInAround > 0 && playersHitInAround == 0);
    }

    private Player getPlayerCloserToBlackJack() {

        final int
                blackJackScore = 21,
                minimumStickScore = 17;

        int closestResultToBlackJack = blackJackScore - minimumStickScore;
        Player closestPlayerToBlackJack = null;

        for (Player player : players) {

            if (!player.getStatus().equals(PlayerStatus.BUSTED)) {

                final int playerDifferenceToBlackJack = blackJackScore - player.getScore();

                if (playerDifferenceToBlackJack <= closestResultToBlackJack) {

                    closestPlayerToBlackJack = player;
                    closestResultToBlackJack = playerDifferenceToBlackJack;
                }
            }
        }

        return closestPlayerToBlackJack;
    }

    private Player getFirstBlackPlayer() {

        Player winner = null;

        for (Player player : players) {

            if (player.getStatus().equals(PlayerStatus.BLACKJACK)) {
                winner = player;
                break;
            }
        }
        return winner;
    }

    private void showMessage(String message, Object... params) {

        System.out.println(format(message, params));
    }

}
