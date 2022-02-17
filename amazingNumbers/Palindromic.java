package numbers;

public class Palindromic {

    protected static boolean palindromic (long number) {

        StringBuilder stringBuilder = new StringBuilder();
        String number2 = String.valueOf(number);
        for (int i = number2.length() - 1; i >= 0; i--) {

            stringBuilder.append(number2.charAt(i));
        }
        return number2.equals(stringBuilder.toString());
    }
}
