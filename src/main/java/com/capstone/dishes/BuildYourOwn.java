package com.capstone.dishes;

public class BuildYourOwn extends Plate{
    public BuildYourOwn(){
        super(999,999);
        this.totalPrice = 0;
        this.platePrice = 0;
        this.name = "Custom Plate";
    }

    @Override
    public void addEntree(MenuItem entree){
            entrees.add(entree);
            totalPrice += entree.getPrice();
    }

    @Override
    public void addSide(MenuItem side){
            sides.add(side);
            totalPrice += side.getPrice();
    }
}
