package com.capstone;

import com.capstone.dishes.*;
import com.capstone.services.DisplayFormatters;
import com.capstone.services.DisplayManager;
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
                default:{
                    System.out.println("Error! Please try again.");
                }
            }
        }
    }

    static void plateHandler(Plate plate){

        DisplayManager.entreeMenu(plate);
        DisplayManager.sideMenu(plate);

        boolean isRunning = true;
        while(isRunning){

            String[] menuList = {"1: Edit entrees","2: Edit sides", "3: Add drinks","4: Add sauces","5: Add desserts","0: Proceed to Checkout"};
            DisplayFormatters.screenDisplay("Customise your plate", menuList);
            int userChoice = InputValidators.getUserNumberInput("Enter chosen number here.",5);

            switch (userChoice){
                case 3 : {
                    DisplayManager.drinkMenu(plate);
                    break;
                }
                case 4 : {
                    DisplayManager.sauceMenu(plate);
                    break;
                }
                case 5 : {
                    DisplayManager.dessertMenu(plate);
                    break;
                }
                case 0 : {
                    isRunning = false;
                    break;
                }

            }
        }


        System.out.println("Here is your selected menu, check and proceed to checkout.");
        DisplayFormatters.receiptDisplay(plate);

        InputValidators.enterToContinue();
    }
}
