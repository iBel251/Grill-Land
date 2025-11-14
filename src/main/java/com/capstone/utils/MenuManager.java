package com.capstone.utils;

import com.capstone.RestaurantMenu;
import com.capstone.dishes.BuildYourOwn;
import com.capstone.dishes.MenuItem;
import com.capstone.dishes.Plate;
import com.capstone.ui.Menu;

import java.util.ArrayList;

public class MenuManager {
    public static void entreeMenu(Plate plate){

        String[] variants = {"1: Rare", "2: Medium Rare","3: Medium","4: Medium Well","5: Well Done"};

        DisplayFormatters.menuDisplay("Choose Entree", RestaurantMenu.entreeMenu);
        int i = 1;
        boolean isBuildYourOwn = plate instanceof BuildYourOwn;

        while (true) {

            if ((plate.getAllowedEntrees() == plate.getEntrees().size()) && !isBuildYourOwn) {
                DisplayFormatters.warningDisplay("You have filled the Entrees allowed for your plate. After these each entree will be charged.");
            }

            int userChoice = InputValidators.getUserNumberInput("Select Entree " + i + " (0 when you are done) ", RestaurantMenu.entreeCount);
            if (userChoice == 0) {
                if (!isBuildYourOwn) {
                    int minimum = plate.getAllowedEntrees();
                    int added = plate.getEntrees().size();
                    int remaining = minimum - added;
                    if (remaining > 0) {
                        String text = plate.getName() + " requires atleast " + minimum + " Entrees. Must choose " + remaining + " more to proceed.";
                        i--;
                        DisplayFormatters.warningDisplay(text);
                        continue;
                    }else{
                        break;
                    }
                } else {
                    break;
                }

            } else {
                MenuItem item = Filters.filterByCategoryAndId("entree", userChoice);
                assert item != null;
                MenuItem clonedItem = new MenuItem(item);

                if (Tools.variantApplicableEntreeIds.contains(item.getId())) {
                    DisplayFormatters.screenDisplay("How do you like your meat cooked", variants);
                    int input;
                    while(true){
                        input = InputValidators.getUserNumberInput("Enter your chosen number here", 5);
                        if(input >= 1 && input <= 5){
                            break;
                        }else {
                            System.out.println("Invalid input!");
                        }
                    }
                    String chosenVariant = variants[input - 1].split(":")[1].trim();

                    clonedItem.setVariant(chosenVariant);
                }
                plate.addEntree(clonedItem);
                System.out.print("Entree " + i + " - ");
                DisplayFormatters.itemDisplay(clonedItem);
            }
            i++;

        }
    }

    public static void sideMenu(Plate plate){
        DisplayFormatters.menuDisplay("Choose Sides", RestaurantMenu.sideMenu);
        int i = 1;

        while(true){

            boolean isBuildYourOwn = plate instanceof BuildYourOwn;

            if ((plate.getAllowedSides() == plate.getSides().size()) && !isBuildYourOwn) {
                DisplayFormatters.warningDisplay("You have filled the Sides allowed for your plate. After these each side will be charged.");
            }

            int userChoice = InputValidators.getUserNumberInput("Select Side " + i + " (0 when you are done) ",RestaurantMenu.sideCount);
            if(userChoice == 0){
                if (!isBuildYourOwn) {
                    int minimum = plate.getAllowedSides();
                    int added = plate.getSides().size();
                    int remaining = minimum - added;
                    if (remaining > 0) {
                        String text = plate.getName() + " requires atleast " + minimum + " Sides. Must choose " + remaining + " more to proceed.";
                        i--;
                        DisplayFormatters.warningDisplay(text);
                        continue;
                    }else{
                        break;
                    }
                } else {
                    break;
                }
            }else{
                MenuItem item = Filters.filterByCategoryAndId("side", userChoice);
                assert item != null;
                MenuItem clonedItem = new MenuItem(item);
                plate.addSide(clonedItem);
                System.out.print("Side " + i + " - " );
                DisplayFormatters.itemDisplay(clonedItem);
            }
            i++;
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
                assert item != null;
                MenuItem clonedItem = new MenuItem(item);

                if(Tools.sizableItems.contains(item.getName().toLowerCase().split("\\(")[0])){
                    System.out.println("Drink is "+ item.getName().toLowerCase().split("\\(")[0]);

                    DisplayFormatters.screenDisplay("Sizes", sizes);
                    while(true){
                        int sizeChoice = InputValidators.getUserNumberInput("Choose size",3);
                        if(sizeChoice == 2){
                            break;
                        } else if (sizeChoice == 1) {
                            clonedItem.setSize("small");
                            break;
                        }else if(sizeChoice == 3){
                            clonedItem.setSize("large");
                            break;
                        }
                    }
                }
                plate.addDrink(clonedItem);
                System.out.print("Drink " + plate.getDrinks().size() + " - " );
                DisplayFormatters.itemDisplay(clonedItem);
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

    public static void extraMenu(Plate plate){
        DisplayFormatters.menuDisplay("Extra Add-ons", RestaurantMenu.extraMenu);
        while (true){
            int userChoice = InputValidators.getUserNumberInput("Enter selected number here. 0 when you are done",RestaurantMenu.dessertCount);
            if(userChoice == 0){
                break;
            }else if (plate.getExtras().size() >= 6) {
                System.out.println("Maximum add-ons allowed is 8.");
                break;
            }else{
                MenuItem item = Filters.filterByCategoryAndId("extra", userChoice);
                plate.addExtra(item);
                System.out.print("Extra " + plate.getExtras().size() + " - " );
                assert item != null;
                DisplayFormatters.itemDisplay(item);
            }
        }
    }

    public static void removeItem(Plate plate){
        ArrayList<MenuItem> allItems = plate.getAllItems();
        DisplayFormatters.menuDisplay("Current Items",allItems,true);
        int selection = InputValidators.getUserNumberInput("Pick the item to be removed. 0 to return to Menu", allItems.size());
        if(selection == 0 || selection == 99){
            return;
        }
        MenuItem selectedItem = allItems.get(selection - 1);
        plate.removeItem(selectedItem);
        InputValidators.enterToContinue();
    }

}
