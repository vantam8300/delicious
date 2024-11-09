package com.yearup;

public class Chip implements Item{
    private double price;
    private String type;
    private int quantity;

    public Chip() {
    }

    public Chip(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Chip{" +
                "price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
