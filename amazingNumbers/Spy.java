package numbers;

public class Spy {

    protected static boolean spy(long number) {
        String numberString = String.valueOf(number);
        long multiplication = Long.parseLong(String.valueOf(numberString.charAt(0)));
        long sum = Long.parseLong(String.valueOf(numberString.charAt(0)));
        for (int i = 1; i < numberString.length(); i++) {
            multiplication *= Long.parseLong(String.valueOf(numberString.charAt(i)));
            sum += Long.parseLong(String.valueOf(numberString.charAt(i)));
        }
        return multiplication == sum;
    }
    }

