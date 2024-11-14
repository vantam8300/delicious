package com.yearup.item;

import com.yearup.topping.Topping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.yearup.util.Util.CYAN;
import static com.yearup.util.Util.RESET;

public class Order {
    private String orderId;
    private LocalDateTime dateTime;
    private double totalCost;
    private List<Item> items;

    public Order() {

    }


    public Order(String orderId, LocalDateTime dateTime) {
        this.orderId = orderId;
        this.dateTime = dateTime;
        items = new ArrayList<>();
    }
    // display all added entries
    public void displayEntries() {

        System.out.println(CYAN + "******************************" + RESET);

        if (items.isEmpty()) {
            System.out.println(CYAN + "Your Cart Is Empty" + RESET);
        } else {
            System.out.print(CYAN + "Items:\n" + RESET);
            System.out.print(CYAN + "----------------------------------------------------------------------\n" + RESET);
            System.out.print(CYAN + String.format("%-30s %-15s %-15s %s\n", "Name", "Size", "Quantity", "Price") + RESET);
            System.out.print(CYAN + "----------------------------------------------------------------------\n" + RESET);

            double totalPrice = 0.0;

            for (Item item : items) {
                if (item instanceof Sandwich sandwich) {
                    // Write Sandwich details
                    System.out.print(CYAN + String.format("%-30s %-15s %-15d $%.2f%n",
                            sandwich.getBread() + " Sandwich", // Sandwich name
                            sandwich.getSize() + " Inches",
                            sandwich.getQuantity(),           // Quantity
                            sandwich.getPrice()) + RESET);            // Price

                    // Display Toppings for the Sandwich
                    List<Topping> toppings = sandwich.getToppings();  // Assuming getToppings() returns a List<String>
                    if (toppings != null && !toppings.isEmpty()) {
                        System.out.print(CYAN + "  Toppings:\n" + RESET);
                        for (Topping topping : toppings) {
                            System.out.print(CYAN + "   - " + topping.getType() + "\n" + RESET);
                        }
                    }
                } else if (item instanceof Drink drink) {
                    // Write Drink details (including size)
                    System.out.println(CYAN + String.format("%-30s %-15s %-15d $%.2f%n",
                            drink.getFlavor() + " Drink",     // Drink flavor name
                            drink.getSize(),                  // Drink size
                            drink.getQuantity(),              // Quantity
                            drink.getPrice()) + RESET);               // Price
                } else if (item instanceof Chip chip) {
                    // Write Chip details
                    System.out.println(CYAN + String.format("%-46s %-15d $%.2f%n",
                            chip.getType() + " Chips",        // Chip type
                            chip.getQuantity(),               // Quantity
                            chip.getPrice()) + RESET);                // Price
                }
                totalPrice += item.getTotalPrice();
            }
            setTotalCost(totalPrice);
            System.out.println(CYAN + "Total Cost: $" + String.format("%.2f", totalPrice) + "\n\n" + RESET);

        }


    }
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

}
