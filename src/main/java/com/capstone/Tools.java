package com.capstone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tools {
    static Scanner sc = new Scanner(System.in);

    // A method that will take prompt and set of numbers as ArrayList to check if user input
    // and verify it to be a number and within set of the provided numbers.
    public static int getUserInput(String prompt, ArrayList<Integer> check){
        int number;
        while(true){
            System.out.print(prompt + ": ");
            String input = sc.nextLine().trim();
            try{
                number = Integer.parseInt(input);
                if(check.contains(number)){
                    break;
                }else{
                    System.out.println("Input out of range! Only choose from the given numbers.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter the number associated with the menu item.");
            }
        }
        return number;
    }

    //Overload the above method by just providing the prompt only when input range check is not needed.
    public static double getUserInput(String prompt){
        double number;
        while(true){
            System.out.print(prompt + ": ");
            String input = sc.nextLine().trim();
            try{
                number = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Only numerical values are accepted.");
            }
        }
        return number;
    }

    //A method to receive and validate user string input
    public static String getStringInput(String prompt){
        String input;
        while(true){
            System.out.print(prompt + ": ");
            input = sc.nextLine().trim();
            if (input.isBlank()){
                System.out.println("Empty values are not accepted.");
            }else{
                return input;
            }
        }
    }

}
