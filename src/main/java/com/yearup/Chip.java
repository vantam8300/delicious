package com.yearup;

public class Chip extends Item{
    private String type;

    public Chip(int quantity, String type) {
        super(quantity);
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double getTotalPrice() {
        return getQuantity() * getPrice();
    }

    @Override
    public double getPrice() {
        return 1.5;
    }

    @Override
    public String toString() {
        return " Chip Details:" +
                "\n- Type: " + type +
                "\n- Quantity: " + getQuantity() +
                "\n- Price per Item: $" + String.format("%.2f", getPrice()) +
                "\n- Price: $" + String.format("%.2f", getTotalPrice());
    }
}
