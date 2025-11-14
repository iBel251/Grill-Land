package com.capstone.ui;

import com.capstone.dishes.*;
import com.capstone.utils.*;

public class Menu {

        static Plate plate = null;

    public static void start(){
        System.out.println("🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥");
        System.out.println("      WELCOME TO GRILL LAND");
        System.out.println("🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥");
        boolean isRunning = true;
        while(isRunning){
            String[] mainMenu;
            if(plate != null){
                System.out.println("Previous order progress found. You can continue by choosing option 2.");
                mainMenu = new String[]{"1: New Order","2: Continue Order" , "0: Exit (Close the application"};
            }else{
                mainMenu = new String[]{"1: New Order", "0: Exit (Close the application"};
            }
            DisplayFormatters.screenDisplay("Main menu", mainMenu);
            int userChoice = InputValidators.getUserNumberInput("Enter number here", mainMenu.length - 1);
            switch (userChoice){
                case 1 : {
                    startOrder();
                    break;
                }
                case 2 : {
                    plateHandler(plate);
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
                default: {
                    System.out.println("Invalid input. Please chose only from the list provided.");
                    break;
                }
            }
        }
    }

    public static void startOrder(){
        boolean orderInProgress = true;
        while(orderInProgress){
            String[] menu = {"1: Single plate($13.99) "+Colors.BLUE+" 1-Entree, 2-Sides"+Colors.RESET,
                    "2: Double plate($17.99) "+Colors.BLUE+" 2-Entree, 3-Sides"+Colors.RESET,
                    "3: Family plate($25.99) "+Colors.BLUE+" 3-Entree, 4-Sides"+Colors.RESET,
                    "4: Build Your Own Plate",
                    "5: Grill-Land Special",
                    "0: Back to Main"};
            DisplayFormatters.screenDisplay("Choose plate size",menu);
            int userChoice = InputValidators.getUserNumberInput("Enter the number here",5);

            switch (userChoice){
                case 1 :{
                    plate = new SinglePlate();
                    plateHandler(plate);
                    break;
                }
                case 2 :{
                    plate = new DoublePlate();
                    plateHandler(plate);
                    break;
                }
                case 3 :{
                    plate = new FamilyPlate();
                    plateHandler(plate);
                    break;
                }
                case 4 :{
                    plate = new BuildYourOwn();
                    plateHandler(plate);
                    break;
                }
                case 5 :{
                    plate = SignaturePlate.createPreFilled();
                    plateHandler(plate);
                    break;
                }
                case 0 : {
                    orderInProgress = false;
                    break;
                }
                default:{
                    System.out.println("Error! Please try again.");
                    break;
                }
            }
        }
    }

    static void plateHandler(Plate plate){

        if(plate.getAllowedEntrees() > plate.getEntrees().size()){
            MenuManager.entreeMenu(plate);
        }
        if(plate.getAllowedSides() > plate.getSides().size()){
            MenuManager.sideMenu(plate);
        }

        boolean isRunning = true;
        while(isRunning){

            String[] menuList = {"1: Entrees","2: Sides", "3: Drinks","4: Sauces","5: Desserts","6: Extra Add-ons","7: Remove item","0: Proceed to Checkout","99: Back to Main Menu"};
            DisplayFormatters.screenDisplay("Customise your plate", menuList);
            int userChoice = InputValidators.getUserNumberInput("Enter chosen number here",menuList.length - 2);

            switch (userChoice){
                case 1 : {
                    MenuManager.entreeMenu(plate);
                    break;
                }
                case 2 : {
                    MenuManager.sideMenu(plate);
                    break;
                }
                case 3 : {
                    MenuManager.drinkMenu(plate);
                    break;
                }
                case 4 : {
                    MenuManager.sauceMenu(plate);
                    break;
                }
                case 5 : {
                    MenuManager.dessertMenu(plate);
                    break;
                }
                case 6 : {
                    MenuManager.extraMenu(plate);
                    break;
                }
                case 7 : {
                    MenuManager.removeItem(plate);
                    break;
                }
                case 0 : {
                    if(Tools.isPlateEmpty(plate)){
                        System.out.println("Plate is empty! Please choose at least 1 item before checkout.");
                        break;
                    }
                    processCheckout(plate, isRunning);
                    break;
                }
                case 99:{
                    isRunning = false;
                    break;
                }
                default:{
                    System.out.println("Invalid input!");
                    break;
                }
            }
        }




        InputValidators.enterToContinue();
    }

    static void processCheckout(Plate plate, boolean isRunning){
        System.out.println("Here is your selected menu, check and proceed to checkout.");
        DisplayFormatters.receiptDisplay(plate);
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println(Colors.BRIGHT_CYAN + "╠➤ 1: Proceed to checkout"+ Colors.RESET);
        System.out.println(Colors.BRIGHT_RED + "╠➤ 0: Cancel and Back to menu" + Colors.RESET);
        System.out.println("╚══════════════════════════════╝\n");
        int selected = InputValidators.getUserNumberInput("Enter number here",1);
        if(selected == 1){
            FileManager.receiptGenerator(plate);
            InputValidators.enterToContinue();
            isRunning = false;
        } else if (selected == 0) {
            isRunning = true;
            return;
        }else{
            System.out.println("Invalid input.");
        }
    }
}
