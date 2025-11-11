package com.capstone.services;

import com.capstone.RestaurantMenu;
import com.capstone.dishes.MenuItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    public static void getFullMenu(){
        try(BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/menu.csv"))){
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                MenuItem item = new MenuItem(Integer.parseInt(data[0]),data[1],data[2],Double.parseDouble(data[3]),Integer.parseInt(data[4]),data[5]);
                RestaurantMenu.fullMenu.add(item);
                switch (data[2]){
                    case "entree" : {
                        RestaurantMenu.entreeMenu.add(item);
                        RestaurantMenu.entreeCount++;
                        break;
                    }case "side" : {
                        RestaurantMenu.sideMenu.add(item);
                        RestaurantMenu.sideCount++;
                        break;
                    }case "drink" : {
                        RestaurantMenu.drinkMenu.add(item);
                        RestaurantMenu.drinkCount++;
                        break;
                    }case "extra" : {
                        RestaurantMenu.extraMenu.add(item);
                        RestaurantMenu.extraCount++;
                        break;
                    }case "sauce" : {
                        RestaurantMenu.sauceMenu.add(item);
                        RestaurantMenu.sauceCount++;
                        break;
                    }case "dessert" : {
                        RestaurantMenu.dessertMenu.add(item);
                        RestaurantMenu.dessertCount++;
                        break;
                    }
                }
            }
        }catch (IOException e){
            System.out.println("Error! can't read the menu file.");
        }
    }
}
