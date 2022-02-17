package cinema;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Objects;

class RowsSeats {
    protected static String currentIncome = "Current income: $";
    protected static String totalIncome1 = "Total income: $";

    protected static void fillArray(String[][] array) {
        for (String[] strings : array) {
            Arrays.fill(strings, "S");
        }
    }

    protected static void changeStoNumber(String[][] array) {
        System.out.println("Cinema:");
        int k = 1;
        int n = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (Objects.equals(array[0][0], "S")) {
                    array[0][0] = " ";
                } else if (Objects.equals(array[0][j], "S")) {
                    array[0][j] = String.valueOf(k);
                    k++;

                } else if (Objects.equals(array[i][0], "S")) {
                    array[i][0] = String.valueOf(n);
                    n++;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    protected static void tickets(int rows, int seats, int rows2) {
        int halfRows = rows / 2;
        System.out.print("Ticket price: ");
        if (rows * seats < 60) {
            System.out.println("$10");
        } else {
            if (rows2 <= halfRows) {
                System.out.println("$10");
            } else {
                System.out.println("$8");
            }
        }
    }

    protected static void changeStoB(String[][] array, int rows2, int seats2) {
        array[rows2][seats2] = "B";
    }

    protected static void chooseAction() {
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
    }

    protected static void purchasedTickets(String[][] array, int rows, int seats) {
        int purchasedTickets = 0;
        int ticketsFor10 = 10;
        int ticketsFor8 = 8;
        int currentIncome2 = 0;
        int halfRows = rows / 2;
        int availableSeats = rows * seats;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (Objects.equals(array[i][j], "B")) {
                    purchasedTickets++;
                }
                if (Objects.equals(array[i][j], "B") && availableSeats <= 60) {
                    currentIncome2 += ticketsFor10;
                } else if (Objects.equals(array[i][j], "B") && i <= halfRows) {
                    currentIncome2 += ticketsFor10;
                } else if (Objects.equals(array[i][j], "B") && i > halfRows) {
                    currentIncome2 += ticketsFor8;
                }
            }
        }
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        double percentage = ((purchasedTickets / ((double) rows * (double) seats)) * 100);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Percentage: " + df.format(percentage) + "%");
        System.out.println(currentIncome + currentIncome2);
    }

    protected static void totalIncome(int rows, int seats) {
        int totalIncome;
        int halfRows = rows / 2;
        if (rows * seats < 60) {
            totalIncome = rows * seats * 10;
        } else {
            if (rows % 2 == 0) {
                totalIncome = halfRows * seats * 10 + halfRows * seats * 8;
            } else {
                totalIncome = halfRows * seats * 10 + (halfRows + 1)* seats * 8;
            }
        }
        System.out.println(totalIncome1 + totalIncome);
    }

    protected static boolean case1(String[][] array, int rows, int seats, int rows2, int seats2) {
        if (rows2 > rows || seats2 > seats) {
            System.out.println("Wrong input!");
            return true;
        } else if (Objects.equals(array[rows2][seats2], "B")) {
            System.out.println("That ticket has already been purchased!");
            return true;
        } else {
            tickets(rows, seats, rows2);
            changeStoB(array, rows2, seats2);
            return false;
        }
    }

    protected static void case3(String[][] array, int rows, int seats) {
        if (rows * seats < 60) {
            purchasedTickets(array, rows, seats);
            totalIncome(rows, seats);
        } else {
            if (rows % 2 == 0) {
                purchasedTickets(array, rows, seats);
                totalIncome(rows, seats);
            } else {
                purchasedTickets(array, rows, seats);
                totalIncome(rows, seats);
            }
        }
    }
}



