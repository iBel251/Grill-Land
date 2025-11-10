package com.capstone;

import com.capstone.services.DisplayFormatters;
import com.capstone.services.InputValidators;

import java.util.ArrayList;
import java.util.Arrays;

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
                    System.out.println("New order");
                    InputValidators.enterToContinue();
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
}
