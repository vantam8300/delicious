package com.yearup;

import static com.yearup.util.Util.*;

public class AddChipScreen {
    Chip chip;

    // Create Chip instance to store user input data
    public AddChipScreen() {
    }

    // prompt user for chip type and quantity
    public void display() {
        String chipType = null;

        boolean exit = false;
        while (!exit) {
            String chipTypeOption = (String) promptUser("What type of chip would you like\n" +
                    "1 - Lays Classic\n" +
                    "2 - Doritos Nacho Cheese \n" +
                    "3 - Doritos Cool Ranch \n" +
                    "4 - Fritos original \n" +
                    "0 - Go back\n", "String", false);
            switch (Integer.parseInt(chipTypeOption)) {
                case 1:
                    chipType = "Lays Classic";
                    exit = true;
                    break;
                case 2:
                    chipType = "Doritos Nacho Cheese";
                    exit = true;
                    break;
                case 3:
                    chipType = "Doritos Cool Ranch";
                    exit = true;
                    break;
                case 4:
                    chipType = "Fritos original";
                    exit = true;
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }

        int quantity = (int) promptUser("How many would you like to order? ","int", false);
        chip = new Chip(quantity, chipType);
    }
}
