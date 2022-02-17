package cinema;
import java.util.Scanner;

class Main {

    private static int chooseAction;
    private static int rows2;
    private static int seats2;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        String[][] array2 = new String[rows + 1][seats + 1];

        RowsSeats.fillArray(array2);
        do {
            RowsSeats.chooseAction();
            chooseAction = scanner.nextInt();
            switch (chooseAction) {
                case 1:
                    RowsSeats.changeStoNumber(array2);
                    break;
                case 2:
                    do {
                        System.out.println("Enter a row number:");
                        rows2 = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seats2 = scanner.nextInt();
                        if (!RowsSeats.case1(array2, rows, seats, rows2, seats2))
                            break;
                    } while (true);
                    break;
                case 3:
                    RowsSeats.case3(array2, rows, seats);
                    break;
                case 0:
                    break;
            }

        } while (chooseAction != 0);


    }
}

