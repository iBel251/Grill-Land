package com.capstone.services;

import com.capstone.dishes.Plate;

public class Tools {
    public static void delay(int num){
        try{
            Thread.sleep(num);
        }catch (InterruptedException e){
            // Continue with out inturupting the loop.
        }
    }

}
