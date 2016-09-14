package domain.card;

import com.tdd.playground.blackjack.domain.card.Card;
import com.tdd.playground.blackjack.domain.card.Numeral;
import com.tdd.playground.blackjack.domain.card.Suit;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardUnitTest {

    @Test
    public void itShouldReturnExpectedValueAndSuitWhenNumberCard() {

        Card card = new Card(Suit.HEARTS, Numeral.NINE);

        assertThat(card.getValue()).isEqualTo(9);
        assertThat(card.getSuit()).isEqualTo("Hearts");
    }

    @Test
    public void itShouldReturnExpectedValueWhenFigureCard() {

        Card card = new Card(Suit.DIAMONDS, Numeral.KING);

        assertThat(card.getValue()).isEqualTo(10);
        assertThat(card.getSuit()).isEqualTo("Diamonds");
    }

    @Test
    public void itShouldReturnExpectedValueWhenAceCard() {

        Card card = new Card(Suit.SPADES, Numeral.ACE);

        assertThat(card.getValue()).isEqualTo(11);
        assertThat(card.getSuit()).isEqualTo("Spades");
    }
}
