package com.yearup.item;

public class Chip extends Item{
    private String type;

    public Chip(int quantity, String type) {
        super(quantity);
        this.type = type;
    }

    public Chip() {

    }

    public String getType() {
        return type;
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

        return  "Chip Detail: " +
                " type=" + type +
                ", quantity=" + getQuantity()+
                ", price=$" + getPrice() +
                ", total price=" + getTotalPrice();
    }
}
