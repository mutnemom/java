package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class Coordinates {
    final static String[] arrayChar = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    public static int index1, index2, column1, column2, maxColumn, minColumn, maxIndex, minIndex;
    public static Scanner scanner = new Scanner(System.in);
    public static String field1, field2;

    protected static void coordinates(String field1, String field2) {

        index1 = Arrays.asList(arrayChar).indexOf(String.valueOf(field1.charAt(0)));
        index2 = Arrays.asList(arrayChar).indexOf(String.valueOf(field2.charAt(0)));
        column1 = Integer.parseInt((field1.substring(1)));
        column2 = Integer.parseInt((field2.substring(1)));
        maxColumn = Math.max(column1, column2);
        minColumn = Math.min(column1, column2);
        maxIndex = Math.max(index1, index2);
        minIndex = Math.min(index1, index2);
    }

    protected static boolean wrongCoordinates(Ships ships) {

        System.out.println("Enter the coordinates of the " + ships.getName() + " (" + ships.getLength() + " cells):");
        field1 = scanner.next();
        field2 = scanner.next();
        coordinates(field1, field2);
        if (index1 != index2) {
            if (Math.abs(index1 - index2) + 1 != ships.getLength()) {
                System.out.println("Error! Wrong length of the " + ships.getName() + "! Try again:");
                return true;

            }
        } else if (column1 != column2) {
            if (Math.abs(column1 - column2) + 1 != ships.getLength()) {
                System.out.println("Error! Wrong length of the " + ships.getName() + "! Try again:");
                return true;
            }
        }
        return false;
    }
}
