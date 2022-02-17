package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Welcome.greeting();
        String input;

        do {
            System.out.println("Enter a request:");
            input = scanner.nextLine();
            String[] firstNumber = Welcome.fillArray(input);
            if (Welcome.checkInput(firstNumber)) {
                if (Long.parseLong(firstNumber[0]) == 0) {
                    break;
                } else if (firstNumber.length > 2) {
                    Welcome.twoPropertiesWhile(Long.parseLong(firstNumber[0]), Long.parseLong(firstNumber[1]), firstNumber);
                } else if (firstNumber.length > 1) {
                    for (int i = 0; i < Long.parseLong(firstNumber[1]); i++) {
                        Welcome.longInput(Long.parseLong(firstNumber[0]) + i);
                    }
                } else {
                    Welcome.welcome(Long.parseLong(firstNumber[0]));
                }

            }
        } while (true);

        System.out.println("Goodbye!");

    }
}

