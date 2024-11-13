package com.yearup.item;

public class Drink extends Item{
    private String size;
    private String flavor;


    public Drink(int quantity, String size, String flavor) {
        super(quantity);
        this.size = size;
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
                "\n- Flavor: " + flavor +
                "\n- Size: " + size +
                "\n- Price per Drink: $" + String.format("%.2f", getPrice()) +
                "\n- Quantity: " + getQuantity() +
                "\n- Price: $" + String.format("%.2f", getTotalPrice());
    }
}
