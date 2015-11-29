package com.tdd.playground.bitcalculator;

import org.junit.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class BitCalculatorUnitTest {

    @Test
    public void shouldReturnExpectedNumberOfBits() {

        //test fixtures
        final BigInteger two = new BigInteger("2");

        //when
        final BigInteger result = two.multiply(two);

        assertThat(result.bitCount()).isEqualTo(1);
        assertThat(result.bitLength()).isEqualTo(3);
    }
}
