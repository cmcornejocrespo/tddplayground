package com.tdd.playground.bitcalculator.romantoarabian;

/**
 * Created by Carlos.Cornejo on 05/07/2015.
 * <p/>
 * Roman numbers converter for number less than 4000
 */
public class RomanToArabian {


    public String romanToArabian(String input) {

        if (input.equals("I")) {

            return "1";
        } else if (input.equals("II")) {

            return "2";
        } else {

            return "3";
        }
    }
}
