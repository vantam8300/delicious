package com.yearup.screen;

import com.yearup.item.Drink;

import static com.yearup.util.Util.*;
import static com.yearup.util.Util.promptUser;

public class AddDrinkScreen {
    Drink drink;

    // Create Drink instance to store user input data
    public AddDrinkScreen() {
    }

    public AddDrinkScreen(Drink drink) {
        this.drink = drink;
    }

    // prompt user for drink and quantity
    public void display() {
        String flavor = null;

        boolean exit = false;
        while (!exit) {
            String drinkFlavorOption = (String) promptUser("What flavor of drink would you like\n" +
                    "1 - Coke\n" +
                    "2 - Sprite\n" +
                    "3 - Diet Coke\n" +
                    "4 - Fanta\n" +
                    "5 - Dr pepper\n" +
                    "6 - Root beer\n" +
                    "0 - Go back\n", "String", false);
            switch (drinkFlavorOption) {
                case "1":
                    flavor = "Coke";
                    exit = true;
                    break;
                case "2":
                    flavor = "Sprite";
                    exit = true;
                    break;
                case "3":
                    flavor = "Diet Coke";
                    exit = true;
                    break;
                case "4":
                    flavor = "Fanta";
                    exit = true;
                    break;
                case "5":
                    flavor = "Dr pepper";
                    exit = true;
                    break;
                case "6":
                    flavor = "Root beer";
                    exit = true;
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }

            if (flavor != null) {
                String size = getSize();
                int quantity = (int) promptUser("How many would you like to order? ","int", false);
                drink = new Drink(quantity, size, flavor);
            }
        }
    }

    private String getSize() {
        String size = null;
        boolean exit = false;
        while (!exit) {
            String sizeOption = (String) promptUser("select size\n" +
                    "1 - Small\n" +
                    "2 - Medium\n" +
                    "3 - Large\n", "string", false);
            switch (Integer.parseInt(sizeOption)) {
                case 1:
                    size = "small";
                    exit = true;
                    break;
                case 2:
                    size = "medium";
                    exit = true;
                    break;
                case 3:
                    size = "large";
                    exit = true;
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }
        return size;
    }

}
