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
    }
}
