package com.yearup;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.yearup.util.Util.*;

public class NewOrderScreen {
    Order order;

    // initiate a Order instance with random id and dateTime is now
    public NewOrderScreen() {
        order = new Order(UUID.randomUUID().toString(), LocalDateTime.now());
    }

    // display all added entries
    public void displayEntries() {
        for (Item item : order.getItems()) {
            if (item instanceof Sandwich) {
                System.out.println(CYAN + "  - " + item + RESET);
            } else if (item instanceof Drink) {
                System.out.println(CYAN + "  - " + item + RESET);
            } else if (item instanceof Chip) {
                System.out.println(CYAN + "  - " + item + RESET);
            }
        }
    }


    // display New Order Menu
    public void displayMenu() {
        boolean exit = false;
        while (!exit) {
            displayEntries();
            String newOrderOption = (String) promptUser(
                    "******************************\n" +
                            "1 - Add Sandwich\n" +
                            "2 - Add Drink\n" +
                            "3 - Add Chips\n" +
                            "4 - Checkout\n" +
                            "0 - Cancel Order\n" , "string", false);

            switch (newOrderOption) {
                case "1":
                    processAddSandwichRequest();
                    break;
                case "2":
                    processAddDrinkRequest();
                    break;
                case "3":
                    processAddChipsRequest();
                    break;
                case "4":
                    processCheckoutRequest();
                    break;
                case "0":
                    System.out.println(CYAN + "You canceled the order" + RESET);
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }
    }

    private void processCheckoutRequest() {
    }

    // Initiate Add Chip Screen to display Add Chip menu
    private void processAddChipsRequest() {
        AddChipScreen addChipScreen = new AddChipScreen();
        addChipScreen.display();

        // check if user enter chip then add to order
        if (addChipScreen.chip != null) {
            order.getItems().add(addChipScreen.chip);

        }
    }

    private void processAddDrinkRequest() {
        AddDrinkScreen addDrinkScreen = new AddDrinkScreen();
        addDrinkScreen.display();

        // check if user enter chip then add to order
        if (addDrinkScreen.drink != null) {
            order.getItems().add(addDrinkScreen.drink);

        }
    }

    private void processAddSandwichRequest() {
        AddSandwichScreen addSandwichScreen = new AddSandwichScreen();
        addSandwichScreen.display();
    }


}
