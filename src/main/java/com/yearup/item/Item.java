package com.yearup.item;

public abstract class Item {
    private int quantity;
    private double price;

    public Item(int quantity) {
        this.quantity = quantity;
    }

    public Item() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // calculate total price
    public abstract double getTotalPrice();

    // calculate price for each item
    public abstract double getPrice();


    @Override
    public String toString() {
        return "Item{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
