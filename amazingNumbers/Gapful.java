package numbers;

public class Gapful {

    protected static boolean gapful(long number) {

        String gapful = String.valueOf(number);
        if (gapful.length() < 3) {
            return false;
        } else {
            String concatenation = gapful.charAt(0) + String.valueOf(gapful.charAt(gapful.length() - 1));
            long concatenaion2 = Long.parseLong(concatenation);
            return number % concatenaion2 == 0;
        }
    }
}
