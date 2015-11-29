import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBillCalculatorUnitTest {

    private PhoneBillCalculator sut;

    @Before
    public void setup() {

        sut = new PhoneBillCalculator();
    }

    @Test
    public void shouldSplitInLines() throws ParseException {

        String[] result = sut.splitInLines("00:01:07,400-234-090\n" +
                "00:05:01,701-080-080\n" +
                "00:05:00,400-234-090");

        assertThat(result).hasSize(3);
        assertThat(result[0]).isEqualTo("00:01:07,400-234-090");
        assertThat(result[1]).isEqualTo("00:05:01,701-080-080");
        assertThat(result[2]).isEqualTo("00:05:00,400-234-090");
    }

    @Test
    public void shouldParseInTwo() throws ParseException {

        String[] result = sut.splitLineIntoTimeAndNumber("00:01:07,400-234-090");

        assertThat(result).hasSize(2);
        assertThat(result[0]).isEqualTo("00:01:07");
        assertThat(result[1]).isEqualTo("400-234-090");
    }

    @Test
    public void shouldParseDateAndNumber() throws ParseException {

        int result = sut.getTotalSeconds("00:01:07");

        assertThat(result).isEqualTo(67);
    }

    @Test
    public void shouldCalculateValidPriceBasedOnMinutesLessThan5Mins() throws ParseException {

        int result = sut.calculatePrice("00:01:07");

        assertThat(result).isEqualTo(201);
    }

    @Test
    public void shouldCalculateValidPriceBasedOnMinutes5() throws ParseException {

        int result = sut.calculatePrice("00:05:00");

        assertThat(result).isEqualTo(750);
    }

    @Test
    public void shouldCalculateValidPriceBasedOnMinutesMoreThan5() throws ParseException {

        int result = sut.calculatePrice("00:05:01");

        assertThat(result).isEqualTo(900);
    }

    @Test
    public void shouldConvertPhoneNumberToNumber() {

        long number = sut.convertPhoneToNumber("701-080-080");

        assertThat(number).isEqualTo(701080080);
    }

    @Test
    public void shouldReturnExpectedPrice() throws ParseException {

        final int solution = sut.getSolution("00:01:07,400-234-090\n" +
                "   00:05:01,701-080-080\n" +
                "   00:05:00,400-234-090");

        assertThat(solution).isEqualTo(900);
    }

    @Test
    public void shouldReturnExpectedPriceWithDuplicates() throws ParseException {

        final int solution = sut.getSolution(
                "00:01:07,400-234-090\n" +
                "00:01:07,400-234-090\n" +
                "00:01:07,400-234-090\n" +
                "   00:05:00,701-080-080\n" +
                "   00:05:00,400-234-090");

        assertThat(solution).isEqualTo(750);
    }
}
