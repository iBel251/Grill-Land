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
            }
        }catch (IOException e){
            System.out.println("Error! can't read the menu file.");
        }
    }
}
