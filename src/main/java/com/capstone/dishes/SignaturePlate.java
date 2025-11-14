package com.capstone.dishes;

import com.capstone.utils.Filters;

import java.util.Objects;

public class SignaturePlate extends Plate{

    public SignaturePlate(){
        super(2,3);
        this.totalPrice = 25.99;
        this.platePrice = 25.99;
        this.name = "Grill-Land Special";
    }

    public static SignaturePlate createPreFilled() {

        SignaturePlate plate = new SignaturePlate();

        // ENTREES
        MenuItem entree1 = new MenuItem(Objects.requireNonNull(Filters.filterByCategoryAndId("entree", 2)));
        entree1.setPrice(0);
        plate.addEntree(entree1);

        MenuItem entree2 = new MenuItem(Objects.requireNonNull(Filters.filterByCategoryAndId("entree", 12)));
        entree2.setPrice(0);
        plate.addEntree(entree2);

        // SIDES
        MenuItem side1 = new MenuItem(Objects.requireNonNull(Filters.filterByCategoryAndId("side", 6)));
        side1.setPrice(0);
        plate.addSide(side1);

        MenuItem side2 = new MenuItem(Objects.requireNonNull(Filters.filterByCategoryAndId("side", 7)));
        side2.setPrice(0);
        plate.addSide(side2);

        MenuItem side3 = new MenuItem(Objects.requireNonNull(Filters.filterByCategoryAndId("side", 9)));
        side3.setPrice(0);
        plate.addSide(side3);

        // SAUCES / EXTRAS
        MenuItem sauce1 = new MenuItem(Objects.requireNonNull(Filters.filterByCategoryAndId("sauce", 1)));
        sauce1.setPrice(0);
        plate.addExtra(sauce1);

        MenuItem sauce2 = new MenuItem(Objects.requireNonNull(Filters.filterByCategoryAndId("sauce", 2)));
        sauce2.setPrice(0);
        plate.addExtra(sauce2);

        MenuItem sauce3 = new MenuItem(Objects.requireNonNull(Filters.filterByCategoryAndId("sauce", 3)));
        sauce3.setPrice(0);
        plate.addExtra(sauce3);

        // DRINKS
        MenuItem drink1 = new MenuItem(Objects.requireNonNull(Filters.filterByCategoryAndId("drink", 5)));
        drink1.setPrice(0);
        plate.addDrink(drink1);

        MenuItem drink2 = new MenuItem(Objects.requireNonNull(Filters.filterByCategoryAndId("drink", 7)));
        drink2.setPrice(0);
        plate.addDrink(drink2);

        // DESSERTS
        MenuItem dessert1 = new MenuItem(Objects.requireNonNull(Filters.filterByCategoryAndId("dessert", 3)));
        dessert1.setPrice(0);
        plate.addDessert(dessert1);

        MenuItem dessert2 = new MenuItem(Objects.requireNonNull(Filters.filterByCategoryAndId("dessert", 4)));
        dessert2.setPrice(0);
        plate.addDessert(dessert2);

        return plate;
    }
}
