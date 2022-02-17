package numbers;

public class SquareAndSunny {

    protected static boolean square(long number) {

        double square_root = Math.sqrt(number);
        return ((square_root - Math.floor(square_root)) == 0);
    }

    protected static boolean isSunnyNumber(long number) {
        return square(number + 1);
    }
}
