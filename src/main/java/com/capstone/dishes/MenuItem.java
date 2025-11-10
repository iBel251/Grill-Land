package com.capstone.dishes;

public class MenuItem {
    private int id;
    private String name;
    private String category;
    private double price;
    private int calories;
    private String description;

    public MenuItem(int id,String name, String category, double price, int calories, String description){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.calories = calories;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", calories=" + calories +
                ", description='" + description + '\'' +
                '}';
    }
}
