package battleship;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class GameFieldWhile extends Coordinates {
    static int countX;
    static String[][] arrayPlayer1 = new String[11][11];
    static String[][] arrayFoggyPlayer1 = new String[11][11];
    static String[][] arrayPlayer2 = new String[11][11];



    static String[][] arrayFoggyPlayer2 = new String[11][11];

    public GameFieldWhile() {
    }

    public static String[][] getArrayPlayer1() {
        return arrayPlayer1;
    }
    public static String[][] getArrayFoggyPlayer1() {return arrayFoggyPlayer1;}

    public static String[][] getArrayPlayer2() {
        return arrayPlayer2;
    }
    public static String[][] getArrayFoggyPlayer2() {return arrayFoggyPlayer2;
    }

    static Ships airCraft = new Ships("Aircraft Carrier", 5);
    static  Ships battleShip = new Ships("Battleship", 4);
    static  Ships submarine = new Ships("Submarine", 3);
    static Ships cruiser = new Ships("Cruiser", 3);
    static Ships destroyer = new Ships("Destroyer", 2);
    static Ships airCraft2 = new Ships("Aircraft Carrier", 5);
    static  Ships battleShip2 = new Ships("Battleship", 4);
    static  Ships submarine2 = new Ships("Submarine", 3);
    static Ships cruiser2 = new Ships("Cruiser", 3);
    static Ships destroyer2 = new Ships("Destroyer", 2);
    static  Ships[] arrayShipsPlayer1 = new Ships[]{airCraft, battleShip, submarine, cruiser, destroyer};
    static  Ships[] arrayShipsPlayer2 = new Ships[]{airCraft2, battleShip2, submarine2, cruiser2, destroyer2};

    protected static void gamewhile(String[][] array, String[][] arrayFoggy, Ships[] arrayShipsPlayer) {
        int k = 0;
        Array.setCountO(0);
        do {
            do {

                if (!Coordinates.wrongCoordinates(arrayShipsPlayer[k])) {
                    if (!Array.checkLocation()) {
                        System.out.println("Error! Wrong ship location! Try again:");
                    } else {
                        if (!Array.fillShips(array)) {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                        } else {
                            Array.array(array);

                            (arrayShipsPlayer[k]).setStartRow(minIndex);
                            (arrayShipsPlayer[k]).setStartColumn(minColumn);
                            (arrayShipsPlayer[k]).setEndRow(maxIndex);
                            (arrayShipsPlayer[k]).setEndColumn(maxColumn);
                            k++;
                            break;

                        }
                    }
                }
            } while (true);
        } while (!Array.howManyO());
    }

    public static void letsPlay() {
        String player1 = "Player 1";
        String player2 = "Player 2";
        do {
            Array.array(getArrayFoggyPlayer1());
            System.out.println("---------------------");
            Array.array(getArrayPlayer1());
            System.out.println(player1 + ", it's your turn:");
            game(getArrayPlayer2(), getArrayFoggyPlayer1(), arrayShipsPlayer2);
            if(ifAllSank(getArrayPlayer2()))
                break;
            promptEnterKey();
            Array.array(getArrayFoggyPlayer2());
            System.out.println("---------------------");
            Array.array(getArrayPlayer2());
            System.out.println(player2 + ", it's your turn:");
            game(getArrayPlayer1(), getArrayFoggyPlayer2(), arrayShipsPlayer1);
            if(ifAllSank(getArrayPlayer1()))
                break;
            promptEnterKey();
        } while (true);

    }

    public static void game(String[][] array, String[][] arrayFoggy, Ships[] arrayShipsPlayer) {
        Scanner scanner = new Scanner(System.in);

            String shot = scanner.next();

            int row = Arrays.asList(arrayChar).indexOf(String.valueOf(shot.charAt(0)));
            int column = Integer.parseInt((shot.substring(1)));

            try {
                if (Objects.equals(array[row + 1][column], "O")) {
                    array[row + 1][column] = "X";
                    arrayFoggy[row + 1][column] = "X";
                    if (ifAllSank(array)) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("You hit a ship!");
                    }
                    if (findShip(row, column, array, arrayShipsPlayer)) {
                        System.out.println("You sank a ship!");
                    }
                } else if (Objects.equals(array[row + 1][column], "X")) {
                    System.out.println("You hit a ship!");
                } else if (Objects.equals(array[row + 1][column], "~")) {
                    array[row + 1][column] = "M";
                    arrayFoggy[row + 1][column] = "M";
                    System.out.println("You missed!");
                } else {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                }
            } catch (Exception e) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
    }

    protected static boolean ifAllSank(String[][] array) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (Objects.equals(array[i][j], "X")) {
                    counter++;
                }
            }
        }
        return counter == 17;
    }

    protected static boolean findShip(int row, int column, String[][] array, Ships[] arrayShipsPlayer) {
        for (Ships ship : arrayShipsPlayer) {
            if ((ship.getStartColumn() == column && ship.getStartRow() <= row && ship.getEndRow() >= row)
                    || (ship.getStartRow() == row && ship.getStartColumn() <= column && ship.getEndColumn() >= column)) {
                if (isSank(ship, array)) {
                    return true;
                }
            }
        }
        return false;
    }


    protected static boolean isSank(Ships ship, String[][] array) {
        boolean sanked = true;
        for (int i = ship.getStartRow() + 1; i <= ship.getEndRow() + 1; i++) {
            for (int j = ship.getStartColumn(); j <= ship.getEndColumn(); j++) {
                if (array[i][j] == "X") {
                    sanked &= true;
                } else {
                    sanked &= false;
                }
            }
        }
        return sanked;
    }

    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


