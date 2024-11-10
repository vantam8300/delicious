package com.yearup;

import static com.yearup.util.Util.*;

public class AddSandwichScreen {
    Sandwich sandwich;

    // Create Chip instance to store user input data
    public AddSandwichScreen() {
        sandwich = new Sandwich();
    }

    // prompt user for chip type and quantity
    public void display() {
        boolean exit = false;
        while (!exit) {
            String AddSandwichOption = (String) promptUser(
                    "******************************\n" +
                            "1 - Select your bread      " + (sandwich.getBread() != null ? "✓\n" : "\n" ) +
                            "2 - Select Sandwich Size      " + (sandwich.getSize() != null ? "✓\n" : "\n" ) +
                            "3 - Toppings       " + (sandwich.getToppings() != null ? "✓\n" : "\n" ) +
                            "4 - Toast Your Sandwich?       " + (sandwich.isToasted() != null ? "✓\n" : "\n" ) +
                            "5 - Add To Cart\n" +
                            "0 - Go Back\n" , "string", false);
            switch (AddSandwichOption) {
                case "1":
                    processSelectBreadRequest();
                    break;
                case "2":
                    processSelectSizeRequest();
                    break;
                case "3":
                    processAddToppingRequest();
                    break;
                case "4":
                    processToastRequest();
                    break;
                case "5":
                    processAddToCartRequest();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }

        }
    }

    private void processAddToCartRequest() {
    }

    private void processToastRequest() {
    }

    private void processSelectSizeRequest() {
        String size = null;
        boolean exit = false;
        while (!exit) {
            String sizeOption = (String) promptUser("select size\n" +
                    "1 - 4 Inches       "  + (sandwich.getSize() != null && sandwich.getSize().equals("4") ? "✓\n" : "\n" ) +
                    "2 - 8 Inches       "  + (sandwich.getSize() != null && sandwich.getSize().equals("8") ? "✓\n" : "\n" ) +
                    "3 - 12 Inches      " + (sandwich.getSize() != null && sandwich.getSize().equals("12") ? "✓\n" : "\n" ) , "string", false);
            switch (sizeOption) {
                case "1":
                    size = "4";
                    exit = true;
                    break;
                case "2":
                    size = "8";
                    exit = true;
                    break;
                case "3":
                    size = "12";
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
            sandwich.setSize(size);
        }
    }

    private void processSelectBreadRequest() {
        String bread = null;
        boolean exit = false;
        while (!exit) {
            String breadOption = (String) promptUser("Select Your Bread\n" +
                    "1 - White       "  + (sandwich.getBread() != null && sandwich.getBread().equals("White") ? "✓\n" : "\n" ) +
                    "2 - Wheat       "  + (sandwich.getBread() != null && sandwich.getBread().equals("Wheat") ? "✓\n" : "\n" ) +
                    "3 - Rye      " + (sandwich.getBread() != null && sandwich.getBread().equals("Rye") ? "✓\n" : "\n" ) +
                    "4 - Wrap      " + (sandwich.getBread() != null && sandwich.getBread().equals("Wrap") ? "✓\n" : "\n" ), "string", false);
            switch (breadOption) {
                case "1":
                    bread = "White";
                    exit = true;
                    break;
                case "2":
                    bread = "Wheat";
                    exit = true;
                    break;
                case "3":
                    bread = "Rye";
                    exit = true;
                    break;
                case "4":
                    bread = "Wrap";
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
            sandwich.setBread(bread);
        }
    }

    private void processAddToppingRequest() {

    }
}