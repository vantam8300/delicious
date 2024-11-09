package com.yearup;

public abstract class Item {
    private int quantity;
    private double price;

    public Item(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double getTotalPrice();

    public abstract double getPrice();

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
