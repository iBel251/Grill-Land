package com.capstone.dishes;

import com.capstone.services.DisplayFormatters;

import java.util.ArrayList;

public class Plate {
    private int allowedEntrees;
    private int allowedSides;
    private String name;
    private ArrayList<MenuItem> entrees;
    private ArrayList<MenuItem> sides;
    private ArrayList<MenuItem> drinks;
    private ArrayList<MenuItem> extras;
    private ArrayList<MenuItem> desserts;
    private double totalPrice;

    public Plate(int allowedEntrees, int allowedSides){
        this.allowedEntrees = allowedEntrees;
        this.allowedSides = allowedSides;
        this.entrees = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.extras = new ArrayList<>();
        this.desserts = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addEntree(MenuItem entree){
        if(entrees.size() < allowedEntrees){
            entrees.add(entree);
            totalPrice += entree.getPrice();
        }else{
            System.out.println("Maximum amount of Entrees have already been added.");
        }
    }

    public void addSide(MenuItem side){
        if(sides.size() < allowedSides){
            sides.add(side);
            totalPrice += side.getPrice();
        }else{
            System.out.println("Maximum amount of Sides have already been added.");
        }
    }

    public void addDrink(MenuItem drink){
            drinks.add(drink);
            totalPrice += drink.getPrice();
    }

    public void addExtra(MenuItem extra){
            extras.add(extra);
            if(extras.size() > 3){
                totalPrice += extra.getPrice();
            }
    }

    public void addDessert(MenuItem dessert){
            desserts.add(dessert);
            totalPrice += dessert.getPrice();
    }

    public int getAllowedEntrees() {
        return allowedEntrees;
    }

    public int getAllowedSides() {
        return allowedSides;
    }

    public String getName() {
        return name;
    }

    public ArrayList<MenuItem> getEntrees() {
        return entrees;
    }

    public ArrayList<MenuItem> getSides() {
        return sides;
    }

    public ArrayList<MenuItem> getDrinks() {
        return drinks;
    }

    public ArrayList<MenuItem> getExtras() {
        return extras;
    }

    public ArrayList<MenuItem> getDesserts() {
        return desserts;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public void displayPlate(){
        for(MenuItem item : entrees){
            displayItem(item);
        }
        for(MenuItem item : sides){
            displayItem(item);
        }
        for(MenuItem item : drinks){
            displayItem(item);
        }
        for(MenuItem item : extras){
            displayItem(item);
        }
        for(MenuItem item : desserts){
            displayItem(item);
        }
    }
    public void displayItem(MenuItem item){
        System.out.printf("╠ %-25s $%-7.2f%n",item.getName(),item.getPrice());
    }
}
