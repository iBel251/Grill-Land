package com.capstone;

import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> check = new ArrayList<>(Arrays.asList(1,2,3,4,0,99));
        int num = Tools.getUserInput("Enter number", check);
        double tip = Tools.getUserInput("Tip");
        String text = Tools.getStringInput("Name");

        System.out.println("input is "+num);
        System.out.println("tip is "+tip);
        System.out.println("Hi "+text);
    }
}