package battleship;

import java.util.Arrays;
import java.util.Objects;

public class Array extends Coordinates {

    public static int getCountO() {
        return countO;
    }

    public static void setCountO(int countO) {
        Array.countO = countO;
    }

    protected static int countO;

    protected static void fillArray(String[][] array) {
        for (String[] strings : array) {
            Arrays.fill(strings, "~");
        }
    }

    protected static void array(String[][] array) {

        int x = 1;
        char y = 'A';
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (Objects.equals(array[0][0], "~")) {
                    array[0][0] = " ";
                } else if (Objects.equals(array[0][j], "~")) {
                    array[0][j] = String.valueOf(x);
                    x++;
                } else if (Objects.equals(array[i][0], "~")) {
                    array[i][0] = String.valueOf(y);
                    y++;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    protected static boolean checkLocation() {
        return index1 != index2 && column1 == column2 || index1 == index2 && column1 != column2;
    }

    protected static boolean checkO(String[][] array) {
        boolean check = true;

        for (int i = minIndex + 1; i <= maxIndex + 1; i++) {
                for (int j = minColumn; j <= maxColumn; j++) {
                if (i == 1) {
                    if (Objects.equals(array[i + 1][j], "O")) {
                        check &= false;
                    }
                } else if (i == 10) {
                    if (Objects.equals(array[i - 1][j], "O")) {
                        check &= false;
                    }
                } else if (j == 1) {
                    if (Objects.equals(array[i][j + 1], "O")) {
                        check &= false;
                    }
                } else if (j == 10) {
                    if (Objects.equals(array[i][j - 1], "O")) {
                        check &= false;
                    }
                } else if (Objects.equals(array[i + 1][j], "O") || Objects.equals(array[i - 1][j], "O")
                        || (Objects.equals(array[i][j + 1], "O") || (Objects.equals(array[i][j - 1], "O")))) {
                    check &= false;
                } else {
                    check &= true;

                }
            }
        }
        return check;
    }

    protected static boolean fillShips(String[][] array) {

        if (!checkO(array)) {
            return false;
        }
        for (int i = minIndex + 1; i <= maxIndex + 1; i++) {
            for (int j = minColumn; j <= maxColumn; j++) {
                array[i][j] = "O";
                countO++;
            }
        }
        return true;
    }

    protected static boolean howManyO() {

        return countO == 17;
    }
}

