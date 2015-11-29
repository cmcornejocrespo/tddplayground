package com.java.tdd.playground.arabictoroman;

/**
 * Created by Carlos.Cornejo on 05/07/2015.
 */
public class RomanConverter {

    private static RomanLiteral[] ROMAN_LITERALS = {new RomanLiteral("M", 1000), new RomanLiteral("CM", 900),
            new RomanLiteral("D", 500), new RomanLiteral("CD", 400), new RomanLiteral("C", 100),
            new RomanLiteral("XC", 90), new RomanLiteral("L", 50), new RomanLiteral("XL", 40),
            new RomanLiteral("X", 10), new RomanLiteral("IX", 9), new RomanLiteral("V", 5), new RomanLiteral("IV", 4),
            new RomanLiteral("I", 1)};

    public String convertToRoman(int number) {

        StringBuilder appender = new StringBuilder();

        for (RomanLiteral romanLiteral : ROMAN_LITERALS) {

            while (number >= romanLiteral.getValue()) {
                appender.append(romanLiteral.getSymbol());
                number -= romanLiteral.getValue();
            }
        }

        return appender.toString();
    }

    private static class RomanLiteral {

        private final String symbol;
        private final int value;

        private RomanLiteral(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public String getSymbol() {
            return symbol;
        }
    }
}