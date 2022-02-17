package battleship;


public class Main {

    public static void main(String[] args) {

        GameFieldWhile fieldWhile = new GameFieldWhile();
        Array.fillArray(fieldWhile.getArrayPlayer1());
        Array.fillArray(fieldWhile.getArrayFoggyPlayer1());
        Array.fillArray(fieldWhile.getArrayPlayer2());
        Array.fillArray(fieldWhile.getArrayFoggyPlayer2());
        System.out.println("Player 1, place your ships on the game field");
        Array.array(fieldWhile.getArrayPlayer1());
        GameFieldWhile.gamewhile(GameFieldWhile.getArrayPlayer1(), GameFieldWhile.getArrayFoggyPlayer1(), GameFieldWhile.arrayShipsPlayer1);
        GameFieldWhile.promptEnterKey();
        System.out.println("Player 2, place your ships to the game field");
        Array.array(fieldWhile.getArrayPlayer2());
        GameFieldWhile.gamewhile(GameFieldWhile.getArrayPlayer2(), GameFieldWhile.getArrayFoggyPlayer2(), GameFieldWhile.arrayShipsPlayer2);
        GameFieldWhile.promptEnterKey();

        GameFieldWhile.letsPlay();
    }
}
