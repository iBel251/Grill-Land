package com.capstone;

import com.capstone.dishes.*;
import com.capstone.services.DisplayFormatters;
import com.capstone.services.Filters;
import com.capstone.services.InputValidators;

public class Menu {

    public static void start(){
        System.out.println("Welcome to Grill Land");
        boolean isRunning = true;
        while(isRunning){
            String[] mainMenu = {"1: New Order","2: Login","3: Signup","0: Exit (Close the application"};
            int[] inputCheck = {1,2,3,0};
            DisplayFormatters.screenDisplay("Main menu", mainMenu);
            int userChoice = InputValidators.getUserNumberInput("Enter number here", inputCheck);
            switch (userChoice){
                case 1 : {
                    startOrder();
                    break;
                }
                case 2 : {
                    System.out.println("login");
                    InputValidators.enterToContinue();
                    break;
                }
                case 3 : {
                    System.out.println("signup");
                    InputValidators.enterToContinue();
                    break;
                }
                case 0 : {
                    System.out.println("Bye bye");
                    InputValidators.enterToContinue();
                    isRunning = false;
                    break;
                }
            }
        }
    }

    public static void startOrder(){
        while(true){
            String[] menu = {"1: Single plate($13.99)","2: Double plate($17.99)","3: Family plate($25.99)"};
            DisplayFormatters.screenDisplay("Choose plate size",menu);
            int[] inputCheck = {1,2,3};
            int userChoice = InputValidators.getUserNumberInput("Enter the number here",inputCheck);

            switch (userChoice){
                case 1 :{
                    Plate plate = new SinglePlate();
                    plateHandler(plate);
                    break;
                }
                case 2 :{
                    Plate plate = new DoublePlate();
                    plateHandler(plate);
                    break;
                }
                case 3 :{
                    Plate plate = new FamilyPlate();
                    plateHandler(plate);
                    break;
                }
            }
        }
    }

    static void plateHandler(Plate plate){
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
                DisplayFormatters.itemDisplay(item);            }
        }

            DisplayFormatters.menuDisplay("Sauces Menu", RestaurantMenu.sauceMenu);
        while (true){
            int userChoice = InputValidators.getUserNumberInput("Enter selected number here. 0 if you are done",RestaurantMenu.sauceCount);
            if(userChoice == 0){
                break;
            } else if (plate.getExtras().size() >= 6) {
                System.out.println("Maximum sauces allowed is 6.");
                break;
            }else{
                MenuItem item = Filters.filterByCategoryAndId("sauce", userChoice);
                plate.addExtra(item);
                System.out.print("Sauce " + plate.getExtras().size() + " - " );
                assert item != null;
                DisplayFormatters.itemDisplay(item);            }
        }

            DisplayFormatters.menuDisplay("Drinks", RestaurantMenu.drinkMenu);
        while (true){
            int userChoice = InputValidators.getUserNumberInput("Enter selected number here. 0 when you are done",RestaurantMenu.drinkCount);
            if(userChoice == 0){
                break;
            }else if (plate.getDrinks().size() >= 6) {
                System.out.println("Maximum drinks allowed is 8.");
                break;
            }else{
                MenuItem item = Filters.filterByCategoryAndId("drink", userChoice);
                plate.addDrink(item);
                System.out.print("Drink " + plate.getDrinks().size() + " - " );
                assert item != null;
                DisplayFormatters.itemDisplay(item);            }
        }


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
                DisplayFormatters.itemDisplay(item);            }
        }

        System.out.println("Here is your selected menu, check and proceed to checkout.");
        DisplayFormatters.receiptDisplay(plate);

        InputValidators.enterToContinue();
    }
}
