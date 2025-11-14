package com.capstone.dishes;

import java.util.ArrayList;

public class Plate {
    private int allowedEntrees;
    private int allowedSides;

    protected ArrayList<MenuItem> entrees;
    protected ArrayList<MenuItem> sides;

    private ArrayList<MenuItem> drinks;
    private ArrayList<MenuItem> sauces;
    private ArrayList<MenuItem> desserts;
    private ArrayList<MenuItem> extras;

    protected String name;
    protected double totalPrice;
    protected double platePrice;

    public Plate(int allowedEntrees, int allowedSides){
        this.allowedEntrees = allowedEntrees;
        this.allowedSides = allowedSides;
        this.entrees = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.desserts = new ArrayList<>();
        this.extras = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addEntree(MenuItem entree){
        if(entrees.size() >= allowedEntrees){
            totalPrice += entree.getPrice();
        }
        entrees.add(entree);
    }

    public void addSide(MenuItem side){
        if(sides.size() >= allowedSides){
            totalPrice += side.getPrice();
        }
        sides.add(side);
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

    public void addExtra(MenuItem extra) {
        extras.add(extra);
        totalPrice += extra.getPrice();
    }

    public int getAllowedEntrees() {
        return allowedEntrees;
    }

    public int getAllowedSides() {
        return allowedSides;
    }

    public double getPlatePrice() {
        return platePrice;
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

    public ArrayList<MenuItem> getExtras() {
        return extras;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public ArrayList<MenuItem> getAllItems(){
        ArrayList<MenuItem> allItems = new ArrayList<>();
        allItems.addAll(entrees);
        allItems.addAll(sides);
        allItems.addAll(drinks);
        allItems.addAll(sauces);
        allItems.addAll(desserts);
        allItems.addAll(extras);
        return allItems;
    }

    public void removeItem(MenuItem item){
        boolean isRemoved = false;
        isRemoved = (entrees.remove(item) ||
        sides.remove(item) ||
        drinks.remove(item) ||
        desserts.remove(item) ||
        extras.remove(item) ||
        sauces.remove(item));
        if(isRemoved){
            System.out.println("Item successfully removed.");
        }
    }

    public String buildPlateText() {
        StringBuilder sb = new StringBuilder();

        // ENTREE SECTION
        for (MenuItem item : entrees) {
            if ((entrees.indexOf(item) < allowedEntrees) && !name.equalsIgnoreCase("Custom Plate")) {
                sb.append(String.format("  %-25s Included%n", item.getName()));
            } else {
                sb.append(String.format("  %-25s $%-7.2f%n", item.getName(), item.getPrice()));
            }
        }

        // SIDES
        for (MenuItem item : sides) {
            if ((sides.indexOf(item) < allowedSides) && !name.equalsIgnoreCase("Custom Plate")) {
                sb.append(String.format("  %-25s Included%n", item.getName()));
            } else {
                sb.append(String.format("  %-25s $%-7.2f%n", item.getName(), item.getPrice()));
            }
        }

        // DRINKS
        for (MenuItem item : drinks) {
            sb.append(String.format("  %-25s $%-7.2f%n", item.getName(), item.getPrice()));
        }

        // SAUCES
        for (MenuItem item : sauces) {
            sb.append(String.format("  %-25s $%-7.2f%n", item.getName(), item.getPrice()));
        }

        // DESSERTS
        for (MenuItem item : desserts) {
            sb.append(String.format("  %-25s $%-7.2f%n", item.getName(), item.getPrice()));
        }

        // EXTRAS
        for (MenuItem item : extras) {
            sb.append(String.format("  %-25s $%-7.2f%n", item.getName(), item.getPrice()));
        }

        return sb.toString();
    }


    public void displayPlate(){
        for(MenuItem item : entrees){
            if((entrees.indexOf(item) < allowedEntrees) && !name.equalsIgnoreCase("Custom Plate")){
                displayItem(item,true);
            }else {
                displayItem(item);
            }
        }
        for(MenuItem item : sides){
            if((sides.indexOf(item) < allowedSides)&& !name.equalsIgnoreCase("Custom Plate")){
                displayItem(item,true);
            }else {
                displayItem(item);
            }
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
        for(MenuItem item : extras){
            displayItem(item);
        }
    }
    public void displayItem(MenuItem item, boolean isFree){

        System.out.printf("╠ %-25s %-7s%n",item.getName(),"Included");
    }
    public void displayItem(MenuItem item){
        System.out.printf("╠ %-25s $%-7.2f%n",item.getName(),item.getPrice());
    }
}
