package numbers;

public class BuzzNumbers {

    protected static boolean buzzNumbers(long number) {

        long lastNumber = number % 10;

        if (number < 0) {
            return false;
        }
        if (lastNumber != 7 && number % 7 != 0) {
                return false;
            } else {
                return true;
            }
        }
    }


