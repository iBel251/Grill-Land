package com.capstone.utils;

import com.capstone.dishes.MenuItem;
import com.capstone.dishes.Plate;

import java.util.ArrayList;

public class DisplayFormatters {
    public static void screenDisplay(String title, String[] menuList){
        System.out.println("\n\n╔══════════════════════════════════════════════╗");
        System.out.println("╠═════➤ "+ title);
        System.out.println("╠══════════════════════════════════════════════╣");
        for(String menu : menuList ){
            System.out.println("╠➤ " + menu);
        }
        System.out.println("╚══════════════════════════════════════════════╝\n\n");
    }

    public static void menuDisplay(String title, ArrayList<MenuItem> menu){
        System.out.println("\n\n\n\n\n╔══════════════════════════════════════════════╗");
        System.out.println("╠═════➤ "+ title);
        System.out.println("╠══════════════════════════════════════════════╣");
        for(MenuItem item : menu ){
            itemDisplay(item);
        }
        System.out.println("╚══════════════════════════════════════════════╝\n\n");
    }

    public static void menuDisplay(String title, ArrayList<MenuItem> menu, boolean customId){
        System.out.println("\n\n\n\n\n╔══════════════════════════════════════════════╗");
        System.out.println("╠═════➤ "+ title);
        System.out.println("╠══════════════════════════════════════════════╣");
        int i = 1;
        for(MenuItem item : menu ){
            itemDisplay(item, i);
            i++;
        }
        System.out.println("╚══════════════════════════════════════════════╝\n\n");
    }

    public static void itemDisplay(MenuItem item){
        int id = item.getId();
        String name = item.getName().split("\\(")[0];
        String category = item.getCategory();
        double price = item.getPrice();
        int calorie = item.getCalories();
        String description = item.getDescription();
        char size = item.getSize().toUpperCase().charAt(0);
        System.out.printf("╠ %-2s %-25s $%-7.2f %-8d %s%n",id,name,price,calorie,description);
    }

    public static void itemDisplay(MenuItem item, int index){
        String name = item.getName().split("\\(")[0];
        String category = item.getCategory();
        double price = item.getPrice();
        int calorie = item.getCalories();
        String description = item.getDescription();
        char size = item.getSize().toUpperCase().charAt(0);
        System.out.printf("╠ %-2s %-25s $%-7.2f %-8d %s%n",index,name,price,calorie,description);
    }

    public static void receiptDisplay (Plate plate){
        System.out.println("========= 🍽️ Grill Land Receipt =========\n");

        System.out.printf("%-25s %8s%n", "Item", "Price");
        System.out.println("-----------------------------------------");
        System.out.printf("╠ %-25s $%-7.2f%n",plate.getName(),plate.getPlatePrice());
        plate.displayPlate();

        double subTotal = plate.getTotalPrice();
        double tax = subTotal * 9.5 / 100;
        double total = subTotal + tax;
        System.out.println("-----------------------------------------");
        System.out.printf("%-25s %5s %8.2f%n", "Subtotal", "", subTotal);
        System.out.printf("%-25s %5s %8.2f%n", "Tax (9.5%)", "", tax);
        System.out.printf("%-25s %5s %8.2f%n", "Total", "", total);

        System.out.println("=========================================");
        System.out.printf("%-30s%n", "Thank you for dining with us!");
        System.out.println();
    }



    public static void errorDisplay(String text){
        System.out.println("❌ " + text);
    }
    public static void deniedMessageDisplay(String text){System.out.println("❗ " + text);}
    public static void warningDisplay(String text){System.out.println("❗ " + text);}

}
