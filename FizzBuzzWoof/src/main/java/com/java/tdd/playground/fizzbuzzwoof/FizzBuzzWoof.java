package com.java.tdd.playground.fizzbuzzwoof;

import static java.lang.String.valueOf;

/**
 * Created by Carlos.Cornejo on 04/07/2015.
 */
public class FizzBuzzWoof {

    private static final String
            FIZZ_BUZZ_WOOF = "FizzBuzzWoof",
            FIZZ_BUZZ = "FizzBuzz",
            FIZZ_WOOF = "FizzWoof",
            BUZZ_WOOF = "BuzzWoof",
            FIZZ = "Fizz",
            BUZZ = "Buzz",
            WOOF = "Woof";

    private static final String COMMA = ",";

    public String getResult(int input) {

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= input; i++) {

            if (isDivisibleBy3(i) && isDivisibleBy5(i) && isDivisibleBy7(i)) {
                builder.append(FIZZ_BUZZ_WOOF);
            } else if (isDivisibleBy3(i) && isDivisibleBy5(i)) {
                builder.append(FIZZ_BUZZ);
            } else if (isDivisibleBy3(i) && isDivisibleBy7(i)) {
                builder.append(FIZZ_WOOF);
            } else if (isDivisibleBy5(i) && isDivisibleBy7(i)) {
                builder.append(BUZZ_WOOF);
            } else if (isDivisibleBy3(i)) {
                builder.append(FIZZ);
            } else if (isDivisibleBy5(i)) {
                builder.append(BUZZ);
            } else if (isDivisibleBy7(i)) {
                builder.append(WOOF);
            } else {
                builder.append(valueOf(i));
            }
            if (i < input) {
                builder.append(COMMA);
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
