package com.capstone.dishes;

public class MenuItem {
    private String name;
    private String category;
    private double price;

    public MenuItem(String name, String category, double price){
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
