package tictactoe;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class Main {

    final static Scanner scanner = new Scanner(System.in);
    static String[][] array = new String[3][3];
    static String coor1;
    static String coor2;
    static String xOrO = "X";

    public static void main(String[] args) {
        fillGird();
        printGird();
        do {
            System.out.println("Enter the coordinates: ");
            coor1 = scanner.next();
            coor2 = scanner.next();
            if (!checkIfNumber()) {
                System.out.println("You should enter numbers!");
            } else if (checkInput()) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (!check()) {
            } else {

                printGird();
            }
        } while (!checkXorO());
    }

    static void printGird() {
        System.out.println("---------");
        for (String[] strings : array) {
            for (int j = 0; j < strings.length; j++) {
                if (j == 0) {
                    System.out.print("| " + strings[j]);
                } else if (j == strings.length - 1) {
                    System.out.print(strings[j] + " " + "|");
                } else {
                    System.out.print(" " + strings[j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    static boolean checkIfNumber() {
        return coor1.matches("[0-9]") && coor2.matches("[0-9]");
    }

    static boolean checkInput() {
        if (Integer.parseInt(coor1) <= 0 || Integer.parseInt(coor2) <= 0) {
            return true;
        }
        return Integer.parseInt(coor1) - 1 > array.length - 1 || Integer.parseInt(coor2) - 1 > array.length - 1;
    }

    static boolean check() {
        if (Objects.equals(array[Integer.parseInt(coor1) - 1][Integer.parseInt(coor2) - 1], " ")) {
            array[Integer.parseInt(coor1) - 1][Integer.parseInt(coor2) - 1] = xOrO;
            if (xOrO.equals("X")) {
                xOrO = "O";
            } else {
                xOrO = "X";
            }
            return true;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
    }

    static void fillGird() {
        for (String[] strings : array) {
            Arrays.fill(strings, " ");
        }
    }

    static boolean checkDiagonal(String character) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    if (!Objects.equals(array[i][j], character)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean checkDiagonal2(String character) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == array[i].length - j - 1) {
                    if (!Objects.equals(array[i][j], character)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean chceckColumn(String character) {
        for (int i = 0; i < array.length; i++) {
            boolean win = true;
            for (int j = 0; j < array[i].length; j++) {
                if (!Objects.equals(array[j][i], character)) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    static boolean chceckRow(String character) {
        for (int i = 0; i < array.length; i++) {
            boolean win = true;
            for (int j = 0; j < array[i].length; j++) {
                if (!Objects.equals(array[i][j], character)) {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
        }
        return false;
    }

    static boolean checkX() {
        return checkDiagonal("X") || checkDiagonal2("X") || chceckColumn("X") || chceckRow("X");
    }

    static boolean checkO() {
        return checkDiagonal("O") || checkDiagonal2("O") || chceckColumn("O") || chceckRow("O");

    }

    static boolean checkXorO() {
        if (checkX()) {
            System.out.println("X wins");
            return true;
        }
        if (checkO()) {
            System.out.println("O wins");
            return true;
        }
        return false;
    }
}

