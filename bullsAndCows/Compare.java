package bullscows;

import java.util.Scanner;

public class Compare {

    public void compare() {
        String[] secretCode2 = Main.randomString.toString().split("");
        Scanner scanner = new Scanner(System.in);
        Main.number = scanner.next();
        String[] number2 = Main.number.split("");

        for (int i = 0; i < secretCode2.length; i++) {
            if (secretCode2[i].equals(number2[i])) {
                Main.bull++;
            } else if (Main.number.contains(secretCode2[i]))
                Main.cow++;
        }

        if (Main.bull == Main.volume2) {
            System.out.println("Grade: " + Main.bull + " bull");
            System.out.println("Congratulations! You guessed the secret code.");
        } else if (Main.bull == 0 && Main.cow == 0) {
            System.out.println("Grade: None.");
        } else if (Main.bull == 0) {
            System.out.println("Grade: " + Main.cow + " cow");
        } else if (Main.cow == 0) {
            System.out.println("Grade: " + Main.bull + " bull");
        } else {
            System.out.println("Grade: " + Main.bull + " bull and " + Main.cow + " cow");
        }

    }
}
