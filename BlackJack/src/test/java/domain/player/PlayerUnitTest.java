package domain.player;

import com.tdd.playground.blackjack.domain.card.Card;
import com.tdd.playground.blackjack.domain.card.Numeral;
import com.tdd.playground.blackjack.domain.card.Suit;
import com.tdd.playground.blackjack.domain.player.Player;
import com.tdd.playground.blackjack.domain.player.PlayerStatus;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerUnitTest {

    private Player sut;

    @Before
    public void setup() {

        sut = new Player("Any Player");
    }

    @Test
    public void itShouldAllowToAddCards() {

        //test fixtures
        final Card card = new Card(Suit.HEARTS, Numeral.EIGHT);

        //when
        sut.addCard(card);

        //then
        assertThat(sut.getCards()).hasSize(1);
    }

    @Test
    public void itShouldReturnExpectedCardsScore() {

        //test fixtures
        final Card card1 = new Card(Suit.HEARTS, Numeral.EIGHT);
        final Card card2 = new Card(Suit.HEARTS, Numeral.ACE);

        //when
        sut.addCard(card1);
        sut.addCard(card2);

        //then
        assertThat(sut.getScore()).isEqualTo(19);
    }

    @Test
    public void itShouldReturnExpectedPlayerStatusWhenScoreIsLessThan17() {

        //test fixtures
        final Card card = new Card(Suit.HEARTS, Numeral.EIGHT);

        //when
        sut.addCard(card);

        //then
        assertThat(sut.getStatus()).isEqualTo(PlayerStatus.HIT);

    }

    @Test
    public void itShouldReturnExpectedPlayerStatusWhenScoreIsGreaterThan17AndLessThan21() {

        //test fixtures
        final Card card = new Card(Suit.HEARTS, Numeral.TEN);

        //when
        sut.addCard(card);
        sut.addCard(card);

        //then
        assertThat(sut.getStatus()).isEqualTo(PlayerStatus.STICK);

    }

    @Test
    public void itShouldReturnExpectedPlayerStatusWhenScoreIsGreaterThan21() {

        //test fixtures
        final Card card1 = new Card(Suit.HEARTS, Numeral.TEN);
        final Card card2 = new Card(Suit.HEARTS, Numeral.FIVE);
        final Card card3 = new Card(Suit.HEARTS, Numeral.NINE);

        //when
        sut.addCard(card1);
        sut.addCard(card2);
        sut.addCard(card3);

        //then
        assertThat(sut.getStatus()).isEqualTo(PlayerStatus.BUSTED);

    }

    @Test
    public void itShouldReturnExpectedPlayerStatusWhenScoreIs21() {

        //test fixtures
        final Card card1 = new Card(Suit.HEARTS, Numeral.TEN);
        final Card card2 = new Card(Suit.SPADES, Numeral.FIVE);
        final Card card3 = new Card(Suit.DIAMONDS, Numeral.SIX);

        //when
        sut.addCard(card1);
        sut.addCard(card2);
        sut.addCard(card3);

        //then
        assertThat(sut.getStatus()).isEqualTo(PlayerStatus.BLACKJACK);

    }

}
