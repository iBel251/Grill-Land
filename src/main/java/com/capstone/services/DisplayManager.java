package com.capstone.services;

import com.capstone.RestaurantMenu;
import com.capstone.dishes.MenuItem;
import com.capstone.dishes.Plate;

public class DisplayManager {
    public static void entreeMenu(Plate plate){
        DisplayFormatters.menuDisplay("Choose Entree", RestaurantMenu.entreeMenu);
        for(int i=1 ; i<=plate.getAllowedEntrees() ; i++){
            String[] placeholders = {"first","second","third","forth"};
            int userChoice = InputValidators.getUserNumberInput("Enter " + placeholders[i-1] + " selection here",RestaurantMenu.entreeCount);
            if(userChoice == 0){
                System.out.println("Entree must be selected to continue.");
                i--;
            }else{
                MenuItem item = Filters.filterByCategoryAndId("entree", userChoice);
                plate.addEntree(item);
                System.out.print("Entree " + i + " - " );
                assert item != null;
                DisplayFormatters.itemDisplay(item);
            }
        }
    }

    public static void sideMenu(Plate plate){
        DisplayFormatters.menuDisplay("Choose Sides", RestaurantMenu.sideMenu);
        for(int i=1 ; i<=plate.getAllowedSides() ; i++){
            String[] placeholders = {"first","second","third","forth"};
            int userChoice = InputValidators.getUserNumberInput("Enter " + placeholders[i-1] + " selection here",RestaurantMenu.sideCount);
            if(userChoice == 0){
                System.out.println("Side must be selected to continue.");
                i--;
            }else{
                MenuItem item = Filters.filterByCategoryAndId("side", userChoice);
                plate.addSide(item);
                System.out.print("Side " + i + " - " );
                assert item != null;
                DisplayFormatters.itemDisplay(item);
            }
        }
    }

    public static void sauceMenu(Plate plate){
        DisplayFormatters.menuDisplay("Sauces Menu", RestaurantMenu.sauceMenu);
        while (true){
            int userChoice = InputValidators.getUserNumberInput("Enter selected number here. 0 if you are done",RestaurantMenu.sauceCount);
            if(userChoice == 0){
                break;
            } else if (plate.getSauces().size() >= 6) {
                System.out.println("Maximum sauces allowed is 6.");
                break;
            }else{
                MenuItem item = Filters.filterByCategoryAndId("sauce", userChoice);
                plate.addSauce(item);
                System.out.print("Sauce " + plate.getSauces().size() + " - " );
                assert item != null;
                DisplayFormatters.itemDisplay(item);
            }
        }
    }

    public static void drinkMenu(Plate plate) {
        DisplayFormatters.menuDisplay("Drinks", RestaurantMenu.drinkMenu);
        String[] sizes = {"1: Small","2: Medium","3: Large"};
        while (true){
            int userChoice = InputValidators.getUserNumberInput("Enter selected number here. 0 when you are done",RestaurantMenu.drinkCount);
            if(userChoice == 0){
                break;
            }else if (plate.getDrinks().size() >= 6) {
                System.out.println("Maximum drinks allowed is 8.");
                break;
            }else{
                MenuItem item = Filters.filterByCategoryAndId("drink", userChoice);
                DisplayFormatters.screenDisplay("Sizes", sizes);
                while(true){
                    int sizeChoice = InputValidators.getUserNumberInput("Choose size",3);
                    if(sizeChoice == 2){
                        break;
                    } else if (sizeChoice == 1) {
                        assert item != null;
                        item.setSize("small");
                        break;
                    }else if(sizeChoice == 3){
                        assert item != null;
                        item.setSize("large");
                        break;
                    }
                }
                plate.addDrink(item);
                System.out.print("Drink " + plate.getDrinks().size() + " - " );
                assert item != null;
                DisplayFormatters.itemDisplay(item);
            }
        }
    }

    public static void dessertMenu(Plate plate){
        DisplayFormatters.menuDisplay("Desserts", RestaurantMenu.dessertMenu);
        while (true){
            int userChoice = InputValidators.getUserNumberInput("Enter selected number here. 0 when you are done",RestaurantMenu.dessertCount);
            if(userChoice == 0){
                break;
            }else if (plate.getDesserts().size() >= 6) {
                System.out.println("Maximum desserts allowed is 8.");
                break;
            }else{
                MenuItem item = Filters.filterByCategoryAndId("dessert", userChoice);
                plate.addDessert(item);
                System.out.print("Dessert " + plate.getDesserts().size() + " - " );
                assert item != null;
                DisplayFormatters.itemDisplay(item);
            }
        }
    }
}
