package game.blackjack;

import com.tdd.playground.blackjack.domain.card.Card;
import com.tdd.playground.blackjack.domain.card.Numeral;
import com.tdd.playground.blackjack.domain.card.Suit;
import com.tdd.playground.blackjack.domain.player.Player;
import com.tdd.playground.blackjack.game.blackjack.BlackJackCardsGame;
import com.tdd.playground.blackjack.game.deck.DefaultShuffle;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class BlackJackGameUnitTest {

    private DefaultShuffle dealer;

    private BlackJackCardsGame sut;

    @Before
    public void setUp() {

        dealer = mock(DefaultShuffle.class);
        sut = new BlackJackCardsGame(dealer, "BlackJack");

        final Player player1 = new Player("Player 1");
        final Player player2 = new Player("Player 2");
        final Player player3 = new Player("Player 3");

        sut.addPlayer(player1);
        sut.addPlayer(player2);
        sut.addPlayer(player3);
    }

    @Test
    public void itShouldReturnExpectedResultWhenAllPlayersBlackJack() {

        //given
        prepareDeckToReturnAllThreeBlackJack();
        sut.startGame();

        //when
        final Player winner = sut.getWinner();

        //then
        assertThat(winner.getName()).isEqualTo("Player 1");
    }

    @Test
    public void itShouldReturnExpectedResultWhenAllPlayersBusted() {

        //given
        prepareDeckToReturnAllThreeBusted();
        sut.startGame();

        //when
        final Player winner = sut.getWinner();

        //then
        assertThat(winner).isNull();
    }

    @Test
    public void itShouldReturnExpectedResultWhenAllButOnePlayersBusted() {

        //given
        prepareDeckToReturnAllButOnePlayerBusted();
        sut.startGame();

        //when
        final Player winner = sut.getWinner();

        assertThat(winner.getName()).isEqualTo("Player 1");
    }

    @Test
    public void itShouldReturnExpectedResultWhenAllStickAroundAndOneCloserToBlackJack() {

        //given
        prepareDeckToReturnAllStickAroundAndOneCloserToBlackJack();
        sut.startGame();

        final Player winner = sut.getWinner();

        assertThat(winner.getName()).isEqualTo("Player 2");
    }

    @Test
    public void itShouldReturnExpectedResultWhenNoBlackJackAndSomeBustedAndTheRestStickAround() {

        //given
        prepareDeckToReturnSomeBustedSomeStickAroundNoBlackJack();
        sut.startGame();

        final Player winner = sut.getWinner();

        assertThat(winner.getName()).isEqualTo("Player 2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldntAllowNumberOfPlayersOutsideMinBoundary() {

        new BlackJackCardsGame(new DefaultShuffle("any strategy"), 0, "anyName");

        fail("it shouldn't reach here");
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldntAllowNumberOfPlayersOutsideMaxBoundary() {

        new BlackJackCardsGame(new DefaultShuffle("any strategy"), 7, "anyName");

        fail("it shouldn't reach here");
    }

    private void prepareDeckToReturnSomeBustedSomeStickAroundNoBlackJack() {

        given(dealer.dealCard())
                .willReturn(new Card(Suit.SPADES, Numeral.ACE))
                .willReturn(new Card(Suit.DIAMONDS, Numeral.ACE))
                .willReturn(new Card(Suit.HEARTS, Numeral.JACK))
                .willReturn(new Card(Suit.SPADES, Numeral.JACK))
                .willReturn(new Card(Suit.CLUBS, Numeral.NINE))
                .willReturn(new Card(Suit.HEARTS, Numeral.JACK));
    }

    private void prepareDeckToReturnAllStickAroundAndOneCloserToBlackJack() {

        given(dealer.dealCard())
                .willReturn(new Card(Suit.SPADES, Numeral.EIGHT))
                .willReturn(new Card(Suit.DIAMONDS, Numeral.NINE))
                .willReturn(new Card(Suit.HEARTS, Numeral.JACK))
                .willReturn(new Card(Suit.SPADES, Numeral.JACK))
                .willReturn(new Card(Suit.CLUBS, Numeral.NINE))
                .willReturn(new Card(Suit.HEARTS, Numeral.JACK));
    }

    //private helpers
    private void prepareDeckToReturnAllThreeBlackJack() {

        given(dealer.dealCard())
                .willReturn(new Card(Suit.SPADES, Numeral.ACE))
                .willReturn(new Card(Suit.DIAMONDS, Numeral.KING))
                .willReturn(new Card(Suit.HEARTS, Numeral.ACE))
                .willReturn(new Card(Suit.SPADES, Numeral.QUEEN))
                .willReturn(new Card(Suit.CLUBS, Numeral.ACE))
                .willReturn(new Card(Suit.HEARTS, Numeral.JACK));
    }

    private void prepareDeckToReturnAllThreeBusted() {

        given(dealer.dealCard())
                .willReturn(new Card(Suit.SPADES, Numeral.ACE))
                .willReturn(new Card(Suit.DIAMONDS, Numeral.ACE))
                .willReturn(new Card(Suit.HEARTS, Numeral.ACE))
                .willReturn(new Card(Suit.SPADES, Numeral.ACE))
                .willReturn(new Card(Suit.CLUBS, Numeral.ACE))
                .willReturn(new Card(Suit.HEARTS, Numeral.ACE));
    }

    private void prepareDeckToReturnAllButOnePlayerBusted() {

        given(dealer.dealCard())
                .willReturn(new Card(Suit.SPADES, Numeral.KING))
                .willReturn(new Card(Suit.DIAMONDS, Numeral.KING))
                .willReturn(new Card(Suit.HEARTS, Numeral.ACE))
                .willReturn(new Card(Suit.SPADES, Numeral.ACE))
                .willReturn(new Card(Suit.CLUBS, Numeral.ACE))
                .willReturn(new Card(Suit.HEARTS, Numeral.ACE));
    }

}
