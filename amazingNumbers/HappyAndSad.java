package numbers;

public class HappyAndSad {


    protected static int isHappyNumber(long number) {
        long reminder = 0;
        long sum = 0;

        while (number > 0) {
            reminder = number % 10;
            sum = sum + (reminder * reminder);
            number = number / 10;
        }
        return (int) sum;
    }

    protected static boolean happy(long number) {

        long result = number;

        while (result != 1 && result != 4) {
            result = isHappyNumber(result);
        }

        return result == 1;
    }

    protected static boolean sad(long number) {

        long result = number;

        while (result != 1 && result != 4) {
            result = isHappyNumber(result);
        }

        return result != 1;
    }
}
