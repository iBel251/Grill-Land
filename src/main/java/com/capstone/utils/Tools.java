package com.capstone.utils;

import com.capstone.dishes.Plate;

import java.util.ArrayList;
import java.util.Arrays;

public class Tools {
    public static void delay(int num){
        try{
            Thread.sleep(num);
        }catch (InterruptedException e){
            // Continue without inturupting the loop.
        }
    }

    public static ArrayList<String> sizableItems = new ArrayList<>(Arrays.asList("sprite","coke","fanta"));
    public static ArrayList<Integer>variantApplicableEntreeIds = new ArrayList<>(Arrays.asList(1,4,5));
    public static boolean isPlateEmpty(Plate plate){
        return !(plate.getTotalPrice() > 0);
    }

}
