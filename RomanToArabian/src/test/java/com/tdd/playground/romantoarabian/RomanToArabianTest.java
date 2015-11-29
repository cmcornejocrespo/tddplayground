package com.tdd.playground.romantoarabian;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Carlos.Cornejo on 05/07/2015.
 */
public class RomanToArabianTest {

    private RomanToArabian sut;

    @Before
    public void setup() {
        sut = new RomanToArabian();
    }

    @Test
    public void shouldReturnExpectedWhenLessThanIV() {

        String outcome = sut.romanToArabian("I");

        assertEquals("1", outcome);
    }

    @Test
    public void shouldReturn2WhenII() {

        String outcome = sut.romanToArabian("II");

        assertEquals("2", outcome);
    }

    @Test
    public void shouldReturn3WhenIII() {

        String outcome = sut.romanToArabian("III");

        assertEquals("3", outcome);
    }

}
