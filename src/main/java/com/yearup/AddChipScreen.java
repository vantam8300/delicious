package com.yearup;

import static com.yearup.util.Util.*;

public class AddChipScreen {
    Chip chip;

    // Create Chip instance to store user input data
    public AddChipScreen() {
       chip = new Chip();
    }

    // prompt user for chip type and quantity
    public void display() {
        String chipType = null;

        boolean exit = false;
        while (!exit) {
            String chipTypeOption = (String) promptUser("What type of chip would you like" +
                    "1 - Lays Classic\n" +
                    "2 - Doritos Nacho Cheese \n" +
                    "3 - Doritos Cool Ranch \n" +
                    "4 - Fritos original \n" +
                    "0 - Go back", "String", false);
            switch (Integer.parseInt(chipTypeOption)) {
                case 1:
                    chipType = "Lays Classic";
                    break;
                case 2:
                    chipType = "Doritos Nacho Cheese";
                    break;
                case 3:
                    chipType = "Doritos Cool Ranch";
                    break;
                case 4:
                    chipType = "Fritos original";
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }

        chip.setType(chipType);

        int quantity = (int) promptUser("How many would you like to order","int", false);
        chip.setQuantity(quantity);
        chip.setPrice(quantity * 1.5);


    }
}
