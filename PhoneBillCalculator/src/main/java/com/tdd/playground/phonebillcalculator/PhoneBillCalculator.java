package com.tdd.playground.phonebillcalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Long.MAX_VALUE;
import static java.util.Calendar.HOUR;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;

public class PhoneBillCalculator {

    private static final String
            DATE_FORMAT = "HH:mm:ss",
            COMMA = ",",
            NEW_LINE_TAB_REGEX = "\\r?\\n",
            DASH = "-",
            EMPTY = "";

    private final static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    private final static Calendar calendarInstance = GregorianCalendar.getInstance();

    public int solution(String billInput) {

        final Map<String, Integer> phoneNumberListWithTotalAmountOfSeconds = getTotalSecondsPerPhoneNumber(billInput);

        final int maxSecondsInACall = getLongestCallInSeconds(phoneNumberListWithTotalAmountOfSeconds);

        final List<String> listOfPhoneMostCalled = getMostCalledPhoneNumbers(phoneNumberListWithTotalAmountOfSeconds,
                maxSecondsInACall);

        final String mostCalledNumberWithSmallestValue = getTheSmallestPhoneInCaseOfTie(listOfPhoneMostCalled);

        final int totalPrice = getTotalPrice(billInput, mostCalledNumberWithSmallestValue);

        return totalPrice;
    }

    private int getTotalPrice(final String billInput, final String maximumPhoneNumberWithLowerValue) {

        int totalPrice = 0;

        final String[] billLines = splitInLines(billInput);

        for (int i = 0; i < billLines.length; i++) {

            final String[] line = splitLineIntoTimeAndNumber(billLines[i]);

            final String duration = line[0];
            final String telephoneNumber = line[1];

            if (!telephoneNumber.equals(maximumPhoneNumberWithLowerValue)) {
                totalPrice += calculatePrice(duration);
            }

        }
        return totalPrice;
    }

    private String getTheSmallestPhoneInCaseOfTie(final List<String> listOfPhoneMostCalled) {

        //we resolve the tie within the smallest telephone number
        String maximumPhoneNumberWithLowerValue = null;
        long minimumPhoneNumber = MAX_VALUE;

        for (String phoneNumber : listOfPhoneMostCalled) {

            final long phoneNumberAsNumber = convertPhoneToNumber(phoneNumber);

            if (phoneNumberAsNumber < minimumPhoneNumber) {

                minimumPhoneNumber = phoneNumberAsNumber;
                maximumPhoneNumberWithLowerValue = phoneNumber;
            }
        }
        return maximumPhoneNumberWithLowerValue;
    }

    private List<String> getMostCalledPhoneNumbers(final Map<String, Integer> phoneNumberListWithTotalAmountOfSeconds,
                                                   int maxSecondsInACall) {

        //retrieve the phone number/s with the maximum amount of seconds in calls
        final List<String> listOfPhoneMostCalled = new ArrayList<>();

        for (String phoneNumber : phoneNumberListWithTotalAmountOfSeconds.keySet()) {

            final Integer secondsPerCall = phoneNumberListWithTotalAmountOfSeconds.get(phoneNumber);
            if (secondsPerCall == maxSecondsInACall)
                listOfPhoneMostCalled.add(phoneNumber);
        }
        return listOfPhoneMostCalled;
    }

    private int getLongestCallInSeconds(final Map<String, Integer> phoneNumberListWithTotalAmountOfSeconds) {

        int maxSecondsInACall = 0;

        //we obtain the maximum number of seconds of any call
        for (String phoneNumber : phoneNumberListWithTotalAmountOfSeconds.keySet()) {

            final Integer secondsPerCall = phoneNumberListWithTotalAmountOfSeconds.get(phoneNumber);
            if (secondsPerCall > maxSecondsInACall)
                maxSecondsInACall = secondsPerCall;
        }
        return maxSecondsInACall;
    }

    private Map<String, Integer> getTotalSecondsPerPhoneNumber(final String billInput) {

        final Map<String, Integer> phoneEntries = new HashMap<>();

        final String[] billLines = splitInLines(billInput);

        for (int i = 0; i < billLines.length; i++) {

            final String[] line = splitLineIntoTimeAndNumber(billLines[i]);

            final String duration = line[0];
            final String phoneNumber = line[1];

            final int secondsPerCall = calculateNumOfSecondsInACall(duration);

            if (phoneEntries.get(phoneNumber) == null) {

                phoneEntries.put(phoneNumber, secondsPerCall);
            } else {

                final Integer totalSecondsPerCall = phoneEntries.get(phoneNumber);

                phoneEntries.put(phoneNumber, (secondsPerCall + totalSecondsPerCall));
            }
        }
        return phoneEntries;
    }

    public int calculateNumOfSecondsInACall(final String duration) {

        try {

            final Date dateParser = sdf.parse(duration);
            calendarInstance.setTime(dateParser);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        final int hour = calendarInstance.get(HOUR);
        final int minute = calendarInstance.get(MINUTE);
        final int seconds = calendarInstance.get(SECOND);

        return hour * 60 * 60 + minute * 60 + seconds;
    }

    public String[] splitLineIntoTimeAndNumber(final String billLinePair) {

        return billLinePair.split(COMMA);
    }

    public String[] splitInLines(final String billLine) {

        return billLine.split(NEW_LINE_TAB_REGEX);
    }

    public int calculatePrice(final String phoneCallDuration) {

        final int totalPhoneCallSeconds = calculateNumOfSecondsInACall(phoneCallDuration);

        int total;
        if (totalPhoneCallSeconds < 300) {
            total = totalPhoneCallSeconds * 3;
        } else {

            final int secondsInAMinute = 60;
            final int priceOfASecond = 150;

            final int exactMinutes = totalPhoneCallSeconds / secondsInAMinute;

            if (totalPhoneCallSeconds % secondsInAMinute == 0) {

                total = exactMinutes * priceOfASecond;
            } else {
                total = (exactMinutes + 1) * priceOfASecond;
            }
        }
        return total;
    }

    public long convertPhoneToNumber(final String phoneNumber) {

        final String parsedPhoneNumber = phoneNumber.replaceAll(DASH, EMPTY);

        return new Long(parsedPhoneNumber);
    }
}
