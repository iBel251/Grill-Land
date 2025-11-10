package com.capstone.dishes;

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

    public Plate(int allowedEntrees, int allowedSides){
        this.allowedEntrees = allowedEntrees;
        this.allowedSides = allowedSides;
        this.entrees = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.extras = new ArrayList<>();
        this.desserts = new ArrayList<>();
    }

    public void addEntree(MenuItem entree){
        if(entrees.size() < allowedEntrees){
            entrees.add(entree);
        }else{
            System.out.println("Maximum amount of Entrees have already been added.");
        }
    }

    public void addSide(MenuItem side){
        if(sides.size() < allowedSides){
            sides.add(side);
        }else{
            System.out.println("Maximum amount of Sides have already been added.");
        }
    }

    public void addDrink(MenuItem drink){
            drinks.add(drink);
    }

    public void addExtra(MenuItem extra){
            extras.add(extra);
    }

    public void addDesert(MenuItem desert){
            desserts.add(desert);
    }


}
