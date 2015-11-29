import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBillCalculator {

    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public int getSolution(String billInput) throws ParseException {

        final Map<String, Integer> phoneNumberListWithTotalAmountOfSeconds = getTotalSecondsPerPhoneNumber(billInput);

        final int maxSecondsInACall = getLongestCallInSeconds(phoneNumberListWithTotalAmountOfSeconds);

        final List<String> listOfPhoneMostCalled = getMostCalledPhoneNumbers(phoneNumberListWithTotalAmountOfSeconds,
                maxSecondsInACall);

        final String mostCalledNumberWithSmallestValue = getTheSmallestPhoneInCaseOfTie(listOfPhoneMostCalled);

        final int totalPrice = getTotalPrice(billInput, mostCalledNumberWithSmallestValue);

        return totalPrice;
    }

    private int getTotalPrice(String billInput, String maximumPhoneNumberWithLowerValue) throws ParseException {

        int totalPrice = 0;

        final String[] billLines = splitInLines(billInput);

        for (int i = 0; i < billLines.length; i++) {

            final String[] line = splitLineIntoTimeAndNumber(billLines[i]);

            final String duration = line[0];
            final String telephoneNumber = line[1];
            if (!telephoneNumber.equals(maximumPhoneNumberWithLowerValue)) {
                totalPrice = +calculatePrice(duration);
            }

        }
        return totalPrice;
    }

    private String getTheSmallestPhoneInCaseOfTie(List<String> listOfPhoneMostCalled) {

        //we resolve the tie within the smallest telephone number
        String maximumPhoneNumberWithLowerValue = null;
        long minimumPhoneNumber = Long.MAX_VALUE;

        for (String phoneNumber : listOfPhoneMostCalled) {

            final long phoneNumberAsNumber = convertPhoneToNumber(phoneNumber);

            if (phoneNumberAsNumber < minimumPhoneNumber) {

                minimumPhoneNumber = phoneNumberAsNumber;
                maximumPhoneNumberWithLowerValue = phoneNumber;
            }
        }
        return maximumPhoneNumberWithLowerValue;
    }

    private List<String> getMostCalledPhoneNumbers(Map<String, Integer> phoneNumberListWithTotalAmountOfSeconds,
                                                   int maxSecondsInACall) {

        //retrieve the phone number/s with the maximum amount of seconds in calls
        List<String> listOfPhoneMostCalled = new ArrayList<>();

        for (String phoneNumber : phoneNumberListWithTotalAmountOfSeconds.keySet()) {

            final Integer secondsPerCall = phoneNumberListWithTotalAmountOfSeconds.get(phoneNumber);
            if (secondsPerCall == maxSecondsInACall)
                listOfPhoneMostCalled.add(phoneNumber);
        }
        return listOfPhoneMostCalled;
    }

    private int getLongestCallInSeconds(Map<String, Integer> phoneNumberListWithTotalAmountOfSeconds) {
        int maxSecondsInACall = 0;

        //we obtain the maximum number of seconds of any call
        for (String phoneNumber : phoneNumberListWithTotalAmountOfSeconds.keySet()) {

            final Integer secondsPerCall = phoneNumberListWithTotalAmountOfSeconds.get(phoneNumber);
            if (secondsPerCall > maxSecondsInACall)
                maxSecondsInACall = secondsPerCall;
        }
        return maxSecondsInACall;
    }

    private Map<String, Integer> getTotalSecondsPerPhoneNumber(String billInput) throws ParseException {
        Map<String, Integer> numbers = new HashMap<>();

        final String[] billLines = splitInLines(billInput);

        for (int i = 0; i < billLines.length; i++) {

            final String[] line = splitLineIntoTimeAndNumber(billLines[i]);

            final String duration = line[0];
            final String telephoneNumber = line[1];

            final int secondsPerCall = getTotalSeconds(duration);

            if (numbers.get(telephoneNumber) == null) {

                numbers.put(telephoneNumber, secondsPerCall);
            } else {

                final Integer existingNumberOfSecondsPerCall = numbers.get(telephoneNumber);

                numbers.put(telephoneNumber, (secondsPerCall + existingNumberOfSecondsPerCall));
            }
        }
        return numbers;
    }

    public int getTotalSeconds(String duration) throws ParseException {

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(sdf.parse(duration));

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        return hour * 60 * 60 + minute * 60 + seconds;
    }

    public String[] splitLineIntoTimeAndNumber(String s) {
        return s.split(",");
    }

    public String[] splitInLines(String s) {
        return s.split("\\r?\\n");
    }

    public int calculatePrice(String s) throws ParseException {

        final int totalSeconds = getTotalSeconds(s);

        int total;
        if (totalSeconds < 300) {
            total = totalSeconds * 3;
        } else {

            final int exactMinutes = totalSeconds / 60;

            if (totalSeconds % 60 == 0) {

                total = exactMinutes * 150;
            } else {
                total = (exactMinutes + 1) * 150;
            }
        }
        return total;
    }

    public long convertPhoneToNumber(String phoneNumber) {

        return new Long(phoneNumber.replaceAll("-", ""));
    }
}
