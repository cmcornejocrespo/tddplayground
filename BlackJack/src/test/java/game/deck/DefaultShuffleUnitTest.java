package game.deck;

import com.tdd.playground.blackjack.domain.card.Card;
import com.tdd.playground.blackjack.domain.card.Numeral;
import com.tdd.playground.blackjack.domain.card.Suit;
import com.tdd.playground.blackjack.game.deck.DefaultShuffle;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultShuffleUnitTest {

    private DefaultShuffle sut;

    @Before
    public void setUp() {

        sut = new DefaultShuffle("Any Shuffle Strategy");
    }

    @Test
    public void itShouldShuffleCards() {

        //when
        sut.shuffle();

        final Card cardAfterShuffle = sut.dealCard();

        //then
        assertThat(cardAfterShuffle).isNotEqualTo(new Card(Suit.SPADES, Numeral.ACE));

    }
}
