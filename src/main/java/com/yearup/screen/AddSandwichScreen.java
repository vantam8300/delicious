package com.yearup.screen;

import com.yearup.item.Sandwich;

import static com.yearup.util.Util.*;

public class AddSandwichScreen {
    Sandwich sandwich;

    // Create Sandwich instance to store user input data
    public AddSandwichScreen() {
        sandwich = new Sandwich();
    }

    public AddSandwichScreen(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    // prompt user for sandwich option
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
                    exit = processAddToCartRequest();
                    break;
                case "0":
                    sandwich = null;
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }
        if (sandwich != null) {
            int quantity = (int) promptUser("How many would you like to order? ","int", false);
            sandwich.setQuantity(quantity);
        }
    }

    // check if user input all necessary field before add a sandwich to order
    private boolean processAddToCartRequest() {
        if (sandwich.isToasted() != null && sandwich.getSize() != null && sandwich.getBread() != null && !sandwich.getToppings().isEmpty()) {
            return true;
        } else {
            System.out.println(RED + "You need to complete all the options above" + RESET);
            return false;
        }
    }

    // prompt user if they want to toast their bread
    private void processToastRequest() {
        Boolean isToasted = null;
        boolean exit = false;
        while (!exit) {
            String breadOption = (String) promptUser("Would you like to toast your bread\n" +
                    "1 - Yes       "  + (sandwich.isToasted() != null && sandwich.isToasted() ? "✓\n" : "\n" ) +
                    "2 - No       "  + (sandwich.isToasted() != null && !sandwich.isToasted()  ? "✓\n" : "\n" ), "string", false);
            switch (breadOption) {
                case "1":
                    isToasted = true;
                    exit = true;
                    break;
                case "2":
                    isToasted = false;
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
            if (isToasted != null) {
                sandwich.setToasted(isToasted);
            }
        }
    }

    // prompt user for sandwich size
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

    // prompt user for bread type
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

    // navigate and prompt user for topping
    private void processAddToppingRequest() {
        AddToppingScreen addToppingScreen;
        if (sandwich.getToppings() == null || sandwich.getToppings().isEmpty()) {
            addToppingScreen = new AddToppingScreen();
        } else {
            addToppingScreen = new AddToppingScreen(sandwich.getToppings());
        }
        addToppingScreen.display();
        if (addToppingScreen.toppings != null) {
            sandwich.setToppings(addToppingScreen.toppings);
        }
    }
}
