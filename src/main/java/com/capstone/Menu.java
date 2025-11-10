package com.capstone;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    public static void start(){
        System.out.println("Welcome to Grill Land");
        boolean isRunning = true;
        while(isRunning){
            String[] mainMenu = {"1: New Order","2: Login","3: Signup","0: Exit (Close the application"};
            ArrayList<Integer> inputCheck = new ArrayList<>(Arrays.asList(1,2,3,0));
            Tools.menuDisplay("Main menu", mainMenu);
            int userChoice = Tools.getUserInput("Enter number here", inputCheck);
            switch (userChoice){
                case 1 : {
                    System.out.println("New order");
                    Tools.enterToContinue();
                    break;
                }
                case 2 : {
                    System.out.println("login");
                    Tools.enterToContinue();
                    break;
                }
                case 3 : {
                    System.out.println("signup");
                    Tools.enterToContinue();
                    break;
                }
                case 0 : {
                    System.out.println("Bye bye");
                    Tools.enterToContinue();
                    isRunning = false;
                    break;
                }
            }
        }
    }
}
