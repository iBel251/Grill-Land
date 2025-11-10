package com.capstone.services;

import com.capstone.dishes.MenuItem;

import java.util.ArrayList;

public class DisplayFormatters {
    public static void screenDisplay(String title, String[] menuList){
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("╠═════➤ "+ title);
        System.out.println("╠══════════════════════════════════════════════╣");
        for(String menu : menuList ){
            System.out.println("╠➤ " + menu);
        }
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public static void menuDisplay(String title, ArrayList<MenuItem> menu){
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("╠═════➤ "+ title);
        System.out.println("╠══════════════════════════════════════════════╣");
        for(MenuItem item : menu ){
            itemDisplay(item);
        }
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public static void itemDisplay(MenuItem item){
        int id = item.getId();
        String name = item.getName();
        String category = item.getCategory();
        double price = item.getPrice();
        int calorie = item.getCalories();
        String description = item.getDescription();
        System.out.printf("%-2s %-25s %-12s $%-7.2f %-8d %s%n",id,name,category,price,calorie,description);
    }



    public static void errorDisplay(String text){
        System.out.println("❌ " + text);
    }
}
