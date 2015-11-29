package com.java.tdd.playground.arabictoroman;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;


/**
 * Created by Carlos.Cornejo on 05/07/2015.
 */
public class RomanConverterTest {

    @Test
    public void shouldReturnExpectedOutcomeWhen1() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(1);

        assertThat(outcome).isEqualTo("I");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputLessThan4() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(2);

        assertThat(outcome).isEqualTo("II");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIs4() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(4);

        assertThat(outcome).isEqualTo("IV");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIs5() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(5);

        assertThat(outcome).isEqualTo("V");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIsGreaterThan5() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(6);

        assertThat(outcome).isEqualTo("VI");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIsGreaterThan5AndLessThan10() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(8);

        assertThat(outcome).isEqualTo("VIII");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIs9() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(9);

        assertThat(outcome).isEqualTo("IX");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIs10() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(10);

        assertThat(outcome).isEqualTo("X");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIsLess50() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(49);

        assertThat(outcome).isEqualTo("XLIX");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIsLess90() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(89);

        assertThat(outcome).isEqualTo("LXXXIX");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIs90() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(90);

        assertThat(outcome).isEqualTo("XC");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIs120() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(120);

        assertThat(outcome).isEqualTo("CXX");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIs400() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(400);

        assertThat(outcome).isEqualTo("CD");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputLessThan900() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(777);

        assertThat(outcome).isEqualTo("DCCLXXVII");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIs920() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(920);

        assertThat(outcome).isEqualTo("CMXX");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIs1492() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(1492);

        assertThat(outcome).isEqualTo("MCDXCII");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenInputIs2015() {

        RomanConverter sut = new RomanConverter();

        final String outcome = sut.convertToRoman(2015);

        assertThat(outcome).isEqualTo("MMXV");
    }
}