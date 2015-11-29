package com.tdd.playground.java8collections.fizzbuzzwoof;

import static java.lang.String.valueOf;

/**
 * Created by Carlos.Cornejo on 04/07/2015.
 */
public class FizzBuzzWoof {

    public String getResult(int input) {

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= input; i++) {

            if (isDivisibleBy3(i) && isDivisibleBy5(i) && isDivisibleBy7(i)) {
                builder.append("FizzBuzzWoof");
            } else if (isDivisibleBy3(i) && isDivisibleBy5(i)) {
                builder.append("FizzBuzz");
            } else if (isDivisibleBy3(i) && isDivisibleBy7(i)) {
                builder.append("FizzWoof");
            } else if (isDivisibleBy5(i) && isDivisibleBy7(i)) {
                builder.append("BuzzWoof");
            } else if (isDivisibleBy3(i)) {
                builder.append("Fizz");
            } else if (isDivisibleBy5(i)) {
                builder.append("Buzz");
            } else if (isDivisibleBy7(i)) {
                builder.append("Woof");
            } else {
                builder.append(valueOf(i));
            }
            if (i < input) {
                builder.append(",");
            }
        }

        return builder.toString();

    }

    private boolean isDivisibleBy7(int i) {
        return i % 7 == 0;
    }

    private boolean isDivisibleBy5(int i) {
        return i % 5 == 0;
    }

    private boolean isDivisibleBy3(int i) {
        return i % 3 == 0;
    }
}
