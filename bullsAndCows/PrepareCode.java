package bullscows;

public class PrepareCode {

    public void preparedCode() {

        System.out.print("The secret is prepared: ");
        for (int i = 0; i < Main.volume2; i++) {
            System.out.print('*');
        }
        System.out.println(" " + '(' + Main.numbersLetters[0] + '-' + Main.numbersLetters[Main.symbols-1] + ").");
    }
}

