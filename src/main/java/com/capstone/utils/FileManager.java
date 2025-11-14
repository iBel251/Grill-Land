package com.capstone.utils;

import com.capstone.RestaurantMenu;
import com.capstone.dishes.MenuItem;
import com.capstone.dishes.Plate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public static void receiptGenerator(Plate plate){

        StringBuilder sb = new StringBuilder();

        sb.append("====== Grill Land ======\n");
        sb.append("Plate: ").append(plate.getName()).append("\n");
        sb.append("Base Price: $").append(String.format("%.2f", plate.getPlatePrice())).append("\n\n");

        sb.append("Items:\n");
        sb.append(plate.buildPlateText()).append("\n");

        double subtotal = plate.getTotalPrice();
        double tax = subtotal * 0.095;
        double total = subtotal + tax;

        sb.append("Subtotal: $").append(String.format("%.2f", subtotal)).append("\n");
        sb.append("Tax (9.5%): $").append(String.format("%.2f", tax)).append("\n");
        sb.append("Total: $").append(String.format("%.2f", total)).append("\n");
        sb.append("========================\n");

        // create file name
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = time + ".txt";

        Path path = Path.of("receipts/" + fileName);

        try {
            Files.createDirectories(path.getParent());
            Files.writeString(path, sb.toString());
            System.out.println("Receipt saved: " + fileName);
        } catch (Exception e) {
            System.out.println("Could not save receipt: " + e.getMessage());
        }
    }
}
