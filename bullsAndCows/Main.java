package bullscows;

iimport java.util.Random;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static Scanner scanner;
    static int bulls = 0;
    static int cows = 0;
    static String number;
    static String numberRandom;
    static int turn = 0;
    static String characters = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        number = scanner.next();
        if (Integer.parseInt(number) > 36) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");

        } else {
            printStars();
            String secretCode = randomGenerator(Integer.parseInt(number));
            System.out.println(secretCode);
            System.out.println("Okay, let's start a game!");
            do {
                cows = 0;
                bulls = 0;
                System.out.println("Turn " + (turn += 1) + ":");
                numberRandom = scanner.next();
                compareArray(secretCode);
                printResult();
            } while (bulls != Integer.parseInt(number));
        }
    }

    public static String randomGenerator(int number) {
        StringBuilder randomNumber = new StringBuilder();
        Random random = new Random();
        while (!(randomNumber.length() == number)) {
            int random1 = random.nextInt(characters.length());
            if (!randomNumber.toString().contains(String.valueOf(random1))) {
                randomNumber.append(characters.charAt(random1));
            }
            if (randomNumber.length() == number) {
                break;
            }
        }
        return randomNumber.toString();
    }

    static void compareArray(String secret) {
        String[] secretCode1 = secret.split("");
        String[] numberArray = numberRandom.split("");
        for (int i = 0; i < secretCode1.length; i++) {
            if (Arrays.toString(secretCode1).contains(String.valueOf(numberArray[i]))) {
                cows += 1;
            }
            if (secretCode1[i].equals(numberArray[i])) {
                bulls += 1;
                cows -= 1;
            }
        }
    }

    static void printResult() {
        if (bulls == Integer.parseInt(number)) {
            System.out.println("Grade: " + bulls + " bulls\n" +
                    "Congratulations! You guessed the secret code.");
        } else if (cows > 0 && bulls == 0) {
            System.out.println("Grade: " + cows + " cows");
        } else if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
        } else {
            System.out.println("Grade: " + bulls + " bulls and " + cows + " cows");
        }
    }

    static void printStars() {
        System.out.println("Input the number of possible symbols in the code:");
        int possibleSymbols = scanner.nextInt();
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < Integer.parseInt(number); i++) {
            System.out.print("*");
        }
        System.out.println(" (" + characters.charAt(0) + "-" + characters.charAt(9) + ", " + characters.charAt(10) + "-" + characters.charAt(possibleSymbols)+ ")");
    }
}


