package com.capstone.dishes;

import com.capstone.utils.Tools;

public class MenuItem {
    private int id;
    private String name;
    private String category;
    private double price;
    private int calories;
    private String description;
    private String size = "medium";
    private String variant = "normal";

    public MenuItem(int id,String name, String category, double price, int calories, String description){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.calories = calories;
        this.description = description;
    }
    public MenuItem(MenuItem item){
        this.id = item.id;
        this.name = item.name;
        this.category = item.category;
        this.price = item.price;
        this.calories = item.calories;
        this.description = item.description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        if(category.equalsIgnoreCase("drink") && Tools.sizableItems.contains(name.toLowerCase().split("\\(")[0])){
            return name + "(" + size + ")";
        }
        if(category.equalsIgnoreCase("entree") && Tools.variantApplicableEntreeIds.contains(id)){
            return name + "(" + variant + ")";
        }
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
        System.out.println("size set to " + size);
        if (size.equalsIgnoreCase("small")) {
            if(category.equalsIgnoreCase("drink")){
                price *= 0.7;
            }
        } else {
            if (size.equalsIgnoreCase("large")) {
                if(category.equalsIgnoreCase("drink")){
                    price *= 1.3;
                }
            }
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
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
