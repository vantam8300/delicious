package com.yearup.screen;

import com.yearup.item.*;
import com.yearup.topping.Topping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.yearup.util.Util.*;

public class CheckoutScreen {

    public CheckoutScreen() {

    }

    // display Home screen
    public void display(Order order) {
        order.displayEntries();
        boolean exit = false;
        while (!exit) {
            String checkOutOption = (String) promptUser(
                    "******************************\n" +
                            "1 - Confirm\n" +
                            "0 - Cancel\n", "string", false);

            switch (checkOutOption) {
                case "1":
                    processConfirmRequest(order);
                    exit = true;
                    break;

                case "0":
                    processCancelRequest(order);
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }
    }

    private void processCancelRequest(Order order) {
        System.out.println(RED + "Order has been canceled." + RESET);
        order.setItems(new ArrayList<>());  // Clear all items
        order.setTotalCost(0.0);  // Reset the total cost
    }

    private void processConfirmRequest(Order order) {
        // Define the directory and ensure it exists
        File receiptsDir = new File("receipts");
        if (!receiptsDir.exists()) {
            receiptsDir.mkdir();
        }

        // Format the file name based on the order date and time
        DateTimeFormatter fileNameFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = order.getDateTime().format(fileNameFormatter) + ".txt";
        File receiptFile = new File(receiptsDir, fileName);

        try (FileWriter writer = new FileWriter(receiptFile)) {
            writer.write("Order ID: " + order.getOrderId() + "\n");
            writer.write("Date: " + order.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");


            // Write item details
            writer.write("Items:\n");
            writer.write("----------------------------------------------------------------------\n");
            writer.write(String.format("%-30s %-15s %-15s %s\n", "Name", "Size", "Quantity", "Price"));
            writer.write("----------------------------------------------------------------------\n");

            List<Item> items = order.getItems();
            for (Item item : items) {
                if (item instanceof Sandwich sandwich) {
                    // Write Sandwich details
                    writer.write(String.format("%-30s %-15s %-15d $%.2f%n",
                            sandwich.getBread() + " Sandwich", // Sandwich name
                            sandwich.getSize() + " Inches",
                            sandwich.getQuantity(),           // Quantity
                            sandwich.getPrice()));            // Price

                    // Display Toppings for the Sandwich
                    List<Topping> toppings = sandwich.getToppings();  // Assuming getToppings() returns a List<String>
                    if (toppings != null && !toppings.isEmpty()) {
                        writer.write("  Toppings:\n");
                        for (Topping topping : toppings) {
                            writer.write("   - " + topping.getType() + "\n");
                        }
                    }
                } else if (item instanceof Drink drink) {
                    // Write Drink details (including size)
                    writer.write(String.format("%-30s %-15s %-15d $%.2f%n",
                            drink.getFlavor() + " Drink",     // Drink flavor name
                            drink.getSize(),                  // Drink size
                            drink.getQuantity(),              // Quantity
                            drink.getPrice()));               // Price
                } else if (item instanceof Chip chip) {
                    // Write Chip details
                    writer.write(String.format("%-46s %-15d $%.2f%n",
                            chip.getType() + " Chips",        // Chip type
                            chip.getQuantity(),               // Quantity
                            chip.getPrice()));                // Price
                }
            }
            writer.write("Total Cost: $" + String.format("%.2f", order.getTotalCost()) + "\n\n");

            System.out.println(GREEN + "Receipt has been saved to " + receiptFile.getAbsolutePath() + RESET);
        } catch (IOException e) {
            System.out.println(RED + "Failed to write receipt: " + e.getMessage() + RESET);
        }
    }


}
