package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Welcome {
    static String[] property = new String[]{"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "square", "sunny", "jumping", "happy", "sad", "-even", "-odd", "-buzz", "-duck", "-palindromic", "-gapful", "-spy", "-square", "-sunny", "-jumping", "-happy", "-sad"};
    protected static String[] numberStr;
    final static String available = "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]";
    final static String firstParametr = "The first parameter should be a natural number or zero.";
    final static String secondParametr = "The second parameter should be a natural number.";

    protected static void greeting() {
        System.out.println("Welcome to Amazing Numbers!\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "* the first parameter represents a starting number;\n" +
                "* the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit");
    }

    protected static boolean checkInput(String[] array) {
        String[] properties = {"even", "-even", "odd", "-odd", "buzz", "-buzz", "duck", "-duck", "palindromic", "-palindromic", "gapful", "-gapful", "spy", "-spy", "square", "-square", "sunny", "-sunny", "jumping", "-jumping", "happy", "-happy", "sad", "-sad"};
        ArrayList<String> fails = new ArrayList<>();
        boolean b1 = true;
        boolean b2 = true;
        boolean b3 = true;
        boolean b4 = true;
        boolean b5 = true;
        if (array.length >= 1) {
            try {
                long l = Long.parseLong(array[0]);
                if (l < 0) {
                    b1 = false;
                }
            } catch (Exception e) {
                b1 = false;
            }
        }
        if (array.length >= 2) {
            try {
                long l = Long.parseLong(array[1]);
                if (l <= 0) {
                    b2 = false;
                }
            } catch (Exception e) {
                b2 = false;
            }

        }
        for (int i = 2; i < array.length; i++) {
            if (!(Arrays.asList(properties).contains(array[i].toLowerCase()))) {
                fails.add(array[i]);
                b3 = false;
            }
        }
        if (Arrays.asList(array).contains("even") && Arrays.asList(array).contains("odd")
                ||(Arrays.asList(array).contains("-even") && Arrays.asList(array).contains("-odd")
                || Arrays.asList(array).contains("sunny") && Arrays.asList(array).contains("square")
                || Arrays.asList(array).contains("duck") && Arrays.asList(array).contains("spy")
                || Arrays.asList(array).contains("happy") && Arrays.asList(array).contains("sad")
        || (Arrays.asList(array).contains("even") && Arrays.asList(array).contains("-even"))
        || (Arrays.asList(array).contains("odd") && Arrays.asList(array).contains("-odd"))
        || (Arrays.asList(array).contains("buzz") && Arrays.asList(array).contains("-buzz"))
        || (Arrays.asList(array).contains("duck") && Arrays.asList(array).contains("-duck"))
        || (Arrays.asList(array).contains("gapful") && Arrays.asList(array).contains("-gapful"))
            || (Arrays.asList(array).contains("palindromic") && Arrays.asList(array).contains("-palindromic"))
            || (Arrays.asList(array).contains("spy") && Arrays.asList(array).contains("-spy"))
            || (Arrays.asList(array).contains("sunny") && Arrays.asList(array).contains("-sunny"))
            || (Arrays.asList(array).contains("jumping") && Arrays.asList(array).contains("-jumping"))
        || (Arrays.asList(array).contains("happy") && Arrays.asList(array).contains("-happy"))
            || (Arrays.asList(array).contains("sad") && Arrays.asList(array).contains("-sad"))
            || (Arrays.asList(array).contains("square") && Arrays.asList(array).contains("-square"))))
        {
            b5 = false;
        }
        if (!b1) {
            System.out.println(firstParametr);
        }
        if (!b2) {
            System.out.println(secondParametr);
        }
        if (fails.size() == 1) {
            System.out.println("The property [" + fails + "] is wrong.\n" + available);
        } else if (fails.size() >= 2) {
            System.out.println("The properties [" + fails + "] are wrong.\n" + available);
        } else if (!b5) {
            System.out.println("The request contains mutually exclusive properties: ["
                    + array[2] + ", " + array[3] + "]\n" +
                    "There are no numbers with these properties.");
        }
        return b1 && b2 && b3 && b4 && b5;
    }

    protected static String[] fillArray(String input) {
        numberStr = input.toLowerCase().split(" ");
        String[] numbers = new String[numberStr.length];
        System.arraycopy(numberStr, 0, numbers, 0, numberStr.length);
        return numbers;
    }

    protected static void welcome(long number) {

        System.out.println("Properties of " + number + "\n" +
                "even: " + "\t" + EvenOrOdd.even(number) + "\n" +
                "odd: " + "\t" + EvenOrOdd.odd(number) + "\n" +
                "buzz: " + "\t" + BuzzNumbers.buzzNumbers(number) + "\n" +
                "duck: " + "\t" + DuckNumbers.duckNumbers(number) + "\n" +
                "palindromic: " + "\t" + Palindromic.palindromic(number) + "\n" +
                "gapful: " + "\t" + Gapful.gapful(number) + "\n" +
                "spy: " + "\t" + Spy.spy(number) + "\n" +
                "square: " + "\t" + SquareAndSunny.square(number) + "\n" +
                "sunny: " + "\t" + SquareAndSunny.isSunnyNumber(number) + "\n" +
                "jumping: " + "\t" + Jumping.jumping(number) + "\n" +
                "happy: " + "\t" + HappyAndSad.happy(number) + "\n" +
                "sad: " + "\t" + HappyAndSad.sad(number));
    }

    protected static void longInput(long number) {
        String result = "";
        if (EvenOrOdd.even(number))
            result += "even, ";

        if (EvenOrOdd.odd(number))
            result += "odd, ";

        if (BuzzNumbers.buzzNumbers(number))
            result += "buzz, ";

        if (DuckNumbers.duckNumbers(number))
            result += "duck, ";

        if (Palindromic.palindromic(number))
            result += "palindromic, ";

        if (Gapful.gapful(number))
            result += "gapful, ";

        if (Spy.spy(number))
            result += "spy, ";

        if (SquareAndSunny.square(number))
            result += "square, ";

        if (SquareAndSunny.isSunnyNumber(number))
            result += "sunny, ";

        if (Jumping.jumping(number))
            result += "jumping, ";

        if (HappyAndSad.happy(number))
            result += "happy, ";

        if (HappyAndSad.sad(number))
            result += "sad, ";

        System.out.println(number + " is " + result.substring(0, result.lastIndexOf(',')));
    }

    protected static boolean switchProperty(long input1, String[] array) {

        boolean result = true;
        for (int j = 2; j < array.length; j++) {
            switch (array[j].toLowerCase()) {
                case "even":
                case "-even":
                    if (Objects.equals(array[j], "even")) {
                        result &= EvenOrOdd.even(input1);
                        break;
                    } else if (Objects.equals(array[j], "-even")) {
                        result &= !EvenOrOdd.even(input1);
                        break;
                    }
                    break;
                case "odd":
                case "-odd":
                    if (Objects.equals(array[j], "odd")) {
                        result &= EvenOrOdd.odd(input1);
                        break;
                    } else if (Objects.equals(array[j], "-odd")) {
                        result &= !EvenOrOdd.odd(input1);
                        break;
                    }
                    break;
                case "buzz":
                case "-buzz":
                    if (Objects.equals(array[j], "buzz")) {
                        result &= BuzzNumbers.buzzNumbers(input1);
                        break;
                    } else if (Objects.equals(array[j], "-buzz")) {
                        result &= !BuzzNumbers.buzzNumbers(input1);
                        break;
                    }
                    break;
                case "duck":
                case "-duck":
                    if (Objects.equals(array[j], "duck")) {
                        result &= DuckNumbers.duckNumbers(input1);
                        break;
                    } else if (Objects.equals(array[j], "-duck")) {
                        result &= !DuckNumbers.duckNumbers(input1);
                        break;
                    }
                    break;
                case "palindromic":
                case "-palindromic":
                    if (Objects.equals(array[j], "palindromic")) {
                        result &= Palindromic.palindromic(input1);
                        break;
                    } else if (Objects.equals(array[j], "-palindromic")) {
                        result &= !Palindromic.palindromic(input1);
                        break;
                    }
                    break;
                case "gapful":
                case "-gapful":
                    if (Objects.equals(array[j], "gapful")) {
                        result &= Gapful.gapful(input1);
                        break;
                    } else if (Objects.equals(array[j], "-palindromic")) {
                        result &= !Gapful.gapful(input1);
                        break;
                    }
                    break;
                case "spy":
                case "-spy":
                    if (Objects.equals(array[j], "spy")) {
                        result &= Spy.spy(input1);
                        break;
                    } else if (Objects.equals(array[j], "-spy")) {
                        result &= !Spy.spy(input1);
                        break;
                    }
                    break;
                case "square":
                case "-square":
                    if (Objects.equals(array[j], "square")) {
                        result &= SquareAndSunny.square(input1);
                        break;
                    } else if (Objects.equals(array[j], "-square")) {
                        result &= !SquareAndSunny.square(input1);
                        break;
                    }
                    break;
                case "sunny":
                case "-sunny":
                    if (Objects.equals(array[j], "sunny")) {
                        result &= SquareAndSunny.isSunnyNumber(input1);
                        break;
                    } else if (Objects.equals(array[j], "-sunny")) {
                        result &= !SquareAndSunny.isSunnyNumber(input1);
                        break;
                    }
                    break;
                case "jumping":
                case "-jumping":
                    if (Objects.equals(array[j], "jumping")) {
                        result &= Jumping.jumping(input1);
                        break;
                    } else if (Objects.equals(array[j], "-jumping")) {
                        result &= !Jumping.jumping(input1);
                        break;
                    }
                    break;
                case "happy":
                case "-happy":
                    if (Objects.equals(array[j], "happy")) {
                        result &= HappyAndSad.happy(input1);
                        break;
                    } else if (Objects.equals(array[j], "-happy")) {
                        result &= !HappyAndSad.happy(input1);
                        break;
                    }
                    break;
                case "sad":
                case "-sad":
                    if (Objects.equals(array[j], "sad")) {
                        result &= HappyAndSad.sad(input1);
                        break;
                    } else if (Objects.equals(array[j], "-sad")) {
                        result &= !HappyAndSad.sad(input1);
                        break;
                    }
                    break;
                default:
                    return false;
            }
        }
        return result;
    }

    protected static void twoPropertiesWhile(long number, long number2, String[] array) {

        long equal = 0;
        long i = number;
        while (equal < number2) {
            if (switchProperty(i, array)) {
                longInput(i);
                equal++;
            }
            i++;
        }
    }
}


