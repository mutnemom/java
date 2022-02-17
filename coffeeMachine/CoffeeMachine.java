package machine;

import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int money = 550;
    static int cups = 9;
    static String action;

    public static void main(String[] args) {

        do {
            greeting();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printResources();
                    break;
            }
        } while (!Objects.equals(action, "exit"));
    }

    static void greeting() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        action = scanner.next();
    }
    static void printResources() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water \n%d ml of milk \n%d g of coffee beans \n%d disposable cups \n$%d of money", water, milk, beans,cups, money);
        System.out.println();
    }

    static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String chooseCoffee = scanner.next();
        switch (chooseCoffee) {
            case "1":
                if(checkEspresso()) {
                    water -= 250;
                    beans -= 16;
                    money += 4;
                    cups -= 1;
                }
                break;
            case "2":
                if(checkLatte()) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                    cups -= 1;
                }
                break;
            case "3":
                if(checkCappuccino()) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    money += 6;
                    cups -= 1;
                }
                break;
            case "back":
                break;
        }
    }

    static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        cups += scanner.nextInt();
    }

    static void take() {
        System.out.println("I gave you $" + money);
        money -= money;
    }

    static  boolean checkEspresso() {
        if (water < 250) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (beans < 16) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    static  boolean checkLatte() {
        if (water < 350) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < 75) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (beans < 16) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    static  boolean checkCappuccino() {
        if (water < 200) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < 100) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (beans < 12) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }
}
