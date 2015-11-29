package com.tdd.playground.java8collections.fizzbuzzwoof;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class FizzBuzzWoofAssertJTest {

    private FizzBuzzWoof sut;

    @Before
    public void setUp() {
        sut = new FizzBuzzWoof();
    }

    @Test
    public void shouldReturnExpectedOutComeWhenNonFizzBuzzWoofPrime() {

        //when
        final String outcome = sut.getResult(8);

        //then
        assertThat(outcome).isEqualTo("1,2,Fizz,4,Buzz,Fizz,Woof,8");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenDivisibleBy3() {

        final String outcome = sut.getResult(3);

        assertThat(outcome).isEqualTo("1,2,Fizz");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenDivisibleBy5() {

        final String outcome = sut.getResult(5);

        assertThat(outcome).isEqualTo("1,2,Fizz,4,Buzz");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenDivisibleBy7() {

        final String outcome = sut.getResult(7);

        assertThat(outcome).isEqualTo("1,2,Fizz,4,Buzz,Fizz,Woof");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenDivisibleBy3And5() {

        final String outcome = sut.getResult(15);

        assertThat(outcome).isEqualTo("1,2,Fizz,4,Buzz,Fizz,Woof,8,Fizz,Buzz,11,Fizz,13,Woof,FizzBuzz");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenDivisibleBy3And7() {

        final String outcome = sut.getResult(21);

        assertThat(outcome).isEqualTo("1,2,Fizz,4,Buzz,Fizz,Woof,8,Fizz,Buzz,11,Fizz,13,Woof," +
                "FizzBuzz,16,17,Fizz,19,Buzz,FizzWoof");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenDivisibleBy5And7() {

        final String outcome = sut.getResult(35);

        assertThat(outcome).isEqualTo("1,2,Fizz,4,Buzz,Fizz,Woof,8,Fizz,Buzz,11,Fizz,13,Woof,FizzBuzz,16,17,Fizz,19," +
                "Buzz,FizzWoof,22,23,Fizz,Buzz,26,Fizz,Woof,29,FizzBuzz,31,32,Fizz,34,BuzzWoof");
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenDivisibleBy3And5And7() {

        final String outcome = sut.getResult(105);

        assertThat(outcome).isEqualTo("1,2,Fizz,4,Buzz,Fizz,Woof,8,Fizz,Buzz,11," +
                "Fizz,13,Woof,FizzBuzz,16,17,Fizz,19,Buzz,FizzWoof,22,23,Fizz,Buzz," +
                "26,Fizz,Woof,29,FizzBuzz,31,32,Fizz,34,BuzzWoof,Fizz,37,38,Fizz,Buzz," +
                "41,FizzWoof,43,44,FizzBuzz,46,47,Fizz,Woof,Buzz,Fizz,52,53,Fizz,Buzz," +
                "Woof,Fizz,58,59,FizzBuzz,61,62,FizzWoof,64,Buzz,Fizz,67,68,Fizz,BuzzWoof," +
                "71,Fizz,73,74,FizzBuzz,76,Woof,Fizz,79,Buzz,Fizz,82,83,FizzWoof,Buzz,86," +
                "Fizz,88,89,FizzBuzz,Woof,92,Fizz,94,Buzz,Fizz,97,Woof,Fizz,Buzz,101,Fizz," +
                "103,104,FizzBuzzWoof");
    }
}
