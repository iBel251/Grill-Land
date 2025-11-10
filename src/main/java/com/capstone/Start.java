package com.capstone;

import com.capstone.dishes.MenuItem;
import com.capstone.services.DisplayFormatters;
import com.capstone.services.FileManager;
import com.capstone.services.Filters;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Start {
    public static void main(String[] args) {
//        ArrayList<Integer> check = new ArrayList<>(Arrays.asList(1,2,3,4,0,99));
//        int num = Tools.getUserInput("Enter number", check);
//        double tip = Tools.getUserInput("Tip");
//        String text = Tools.getStringInput("Name");
//
//        System.out.println("input is "+num);
//        System.out.println("tip is "+tip);
//        System.out.println("Hi "+text);
//        String[] menuList = {"1: one","2: two", "3: three"};
//        Tools.menuDisplay("Main menu",menuList);
        FileManager.getFullMenu();

        DisplayFormatters.menuDisplay("Menu", Filters.filterByCategoryAndId("entree",3));
        Menu.start();
    }
}