package com.yearup;

public class Chip implements Item{
    private double price;
    private String type;

    public Chip(double price, String type) {
        this.price = price;
        this.type = type;
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
