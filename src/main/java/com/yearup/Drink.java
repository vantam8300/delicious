package com.yearup;

public class Drink {
    private String size;
    private double price;

    public Drink(String size, double price) {
        this.size = size;
        this.price = price;
    }

    public Drink(String size) {
        this.size = size;
    }

    public double getPrice() {

        if (size.equalsIgnoreCase("small")) {
            this.price = 2.00;
        } else if (size.equalsIgnoreCase("medium")) {
            this.price = 2.50;
        } else if (size.equalsIgnoreCase("large")){
            this.price = 3.00;
        }
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
