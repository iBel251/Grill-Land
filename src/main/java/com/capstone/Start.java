package com.capstone;

import com.capstone.ui.Menu;
import com.capstone.utils.FileManager;

public class Start {
    public static void main(String[] args) {

        FileManager.getFullMenu();
        Menu.start();
    }
}