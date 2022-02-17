package numbers;

public class DuckNumbers {

    protected static boolean duckNumbers(long number) {

        String numberString = String.valueOf(number);
        for (int i = 1; i < numberString.length(); i++) {
            if (numberString.charAt(i) == '0') {
                return true;
            }
            }
        return false;
        }
    }

