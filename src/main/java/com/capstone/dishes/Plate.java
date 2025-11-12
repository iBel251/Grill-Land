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
    private ArrayList<MenuItem> sauces;
    private ArrayList<MenuItem> desserts;
    private double totalPrice;

    public Plate(int allowedEntrees, int allowedSides){
        this.allowedEntrees = allowedEntrees;
        this.allowedSides = allowedSides;
        this.entrees = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.sauces = new ArrayList<>();
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

    public void addSauce(MenuItem sauce){
            sauces.add(sauce);
            if(sauces.size() > 3){
                totalPrice += sauce.getPrice();
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

    public ArrayList<MenuItem> getSauces() {
        return sauces;
    }

    public ArrayList<MenuItem> getDesserts() {
        return desserts;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public void replaceEntree(MenuItem item1, MenuItem item2){
        int index = entrees.indexOf(item1);
        if(index != -1){
            entrees.set(index, item2);
        }
    }
    public void replaceSide(MenuItem item1, MenuItem item2){
        int index = sides.indexOf(item1);
        if(index != -1){
            sides.set(index, item2);
        }
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
        for(MenuItem item : sauces){
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
