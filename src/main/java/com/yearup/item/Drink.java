package com.yearup.item;

public class Drink extends Item{
    private String size;
    private String flavor;


    public Drink(int quantity, String size, String flavor) {
        super(quantity);
        this.size = size;
        this.flavor = flavor;
    }

    public Drink() {

    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    @Override
    public double getTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double getPrice() {

        if (size.equalsIgnoreCase("small")) {
            return 2.00;
        } else if (size.equalsIgnoreCase("medium")) {
            return 2.50;
        } else if (size.equalsIgnoreCase("large")){
            return 3.00;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Drink Details:" +
                " flavor=" + flavor  +
                ", size=" + size  +
                ", price=$" + getPrice() +
                ", quantity=" + getQuantity() +
                ", total price=" + getTotalPrice();
    }
}
