package com.yearup.screen;

import com.yearup.item.*;
import com.yearup.topping.Cheese;
import com.yearup.topping.Meat;
import com.yearup.topping.OtherTopping;
import com.yearup.topping.Sauce;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.yearup.util.Util.*;

public class NewOrderScreen {
    Order order;

    // initiate an Order instance with random id and dateTime is now
    public NewOrderScreen() {
        order = new Order(UUID.randomUUID().toString(), LocalDateTime.now());
    }




    // display New Order Menu
    public void displayMenu() {
        boolean exit = false;
        while (!exit) {
            order.displayEntries();
            String newOrderOption = (String) promptUser(
                    "******************************\n" +
                            "1 - Add Customized Sandwich\n" +
                            "2 - Add Drink\n" +
                            "3 - Add Chips\n" +
                            "4 - Add BLT\n" +
                            "5 - Add Philly Cheese Steak\n" +
                            "6 - Remove Item\n" +
                            "7 - Modify Item\n" +
                            "8 - Checkout\n" +
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
                    processBLTRequest();
                    break;
                case "5":
                    processPCSRequest();
                    break;
                case "6":
                    processRemoveRequest();
                    break;
                case "7":
                    processModifyRequest();
                    break;
                case "8":
                    exit = processCheckoutRequest();
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

    private void displayItems() {
        List<Item> items = order.getItems();
        for (int i=0; i<items.size(); i++) {
            if (items.get(i) instanceof Sandwich sandwich) {
                System.out.println(CYAN + (i+1) + " - " + sandwich + RESET);
            } else if (items.get(i) instanceof Drink drink) {
                System.out.println(CYAN + (i+1) + " - " + drink + RESET);
            } else if (items.get(i) instanceof Chip chip) {
                System.out.println(CYAN + (i+1) + " - " + chip + RESET);
            }
        }
    }

    private void processModifyRequest() {
        displayItems();
        int index = (int) promptUser("Please select an Item you would like to modify: ","int", false);
    }

    private void processRemoveRequest() {
        if (order.getItems().isEmpty()) {
            System.out.println(RED + "Your cart is empty" + RESET);
        } else {
            displayItems();
            int index = (int) promptUser("Please select an Item you would like to modify: ","int", false);
            order.getItems().remove(index - 1);
        }

    }

    private void processPCSRequest() {
        PhillyCheeseStreak pcs = new PhillyCheeseStreak("8", "White", List.of(new Meat("Steak"), new Cheese("American"), new OtherTopping("Peppers"), new Sauce("Mayo")), true);
        AddSandwichScreen addSandwichScreen = new AddSandwichScreen(pcs);
        addSandwichScreen.display();
        order.getItems().add(pcs);
    }

    private void processBLTRequest() {
        BLT blt = new BLT("8", "White", List.of(new Meat("Bacon"), new Cheese("Cheddar"), new OtherTopping("Lettuce"), new Sauce("Ranch")), true);
        AddSandwichScreen addSandwichScreen = new AddSandwichScreen(blt);
        addSandwichScreen.display();
        order.getItems().add(addSandwichScreen.sandwich);
    }

    private boolean processCheckoutRequest() {
        if (order.getItems().isEmpty()) {
            System.out.println(RED + "unable to checkout because your cart is empty" + RESET);
            return false;
        } else {
            CheckoutScreen checkoutScreen = new CheckoutScreen();
            checkoutScreen.display(order);
            return true;
        }
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
        if (addSandwichScreen.sandwich != null) {
            order.getItems().add(addSandwichScreen.sandwich);

        }
    }


}
