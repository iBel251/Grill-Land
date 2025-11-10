package com.capstone.services;

import com.capstone.RestaurantMenu;
import com.capstone.dishes.MenuItem;

import java.util.ArrayList;

public class Filters {
    static ArrayList<MenuItem> fullMenu = RestaurantMenu.fullMenu;

    public static ArrayList<MenuItem> filterByCategory(String category){
        ArrayList<MenuItem> result = new ArrayList<>();
        for(MenuItem item : fullMenu){
            if(item.getCategory().equalsIgnoreCase(category)){
                result.add(item);
            }
        }
        return result;
    }

    public static ArrayList<MenuItem> filterByCategoryAndId(String category, int id){
        ArrayList<MenuItem> result = new ArrayList<>();
        for(MenuItem item : fullMenu){
            if(item.getCategory().equalsIgnoreCase(category) && item.getId() == id){
                result.add(item);
            }
        }
        return result;
    }
}
