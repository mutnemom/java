package bullscows;

import java.util.Random;

class GenerateNum {

    public void generateNum() {
        Random random = new Random();
        if (Main.volume2 >= 36) {
            System.out.println("Error: can't generate a secret number with a length of " + Main.volume + " because there aren't enough unique digits.");
        } else {
            while (Main.randomString.length() < Main.volume2) {
                int temp1 = random.nextInt(Main.symbols);
                if (!Main.randomString.toString().contains(Main.numbersLetters[temp1])) {
                    Main.randomString.append(Main.numbersLetters[temp1]);
                }
            }
        }
        //System.out.println(Main.randomString.toString());
    }
}
