/*
name: Gabriel Coelho Santos
lecturer: Muhammad Ibqal
date: 15th of May
project: VendingMachineApp
file: ConfigProduct
 */
package vendingmachineapp;

/**
 *
 * @author Gabriel
 */
public class PriceOfProducts implements ChangingOfPrice {

    //declaration and initialisation of static variables
    // if I want modify a product value , others code part
    //will not be affected
    public static double CHOCOLATE_PRICE = 1.20;
    public static double CRISP_PRICE = 1.50;
    public static double DRINK_PRICE = 2.0;

    //each product will choose a category and override a method
    //I coded this part based on Polymorphism
    @Override
    public void changeChocolatePrice(double price) {
        CHOCOLATE_PRICE = price;
    }

    @Override
    public void changeCrispPrice(double price) {
        CRISP_PRICE = price;
    }

    @Override
    public void changeDrinkPrice(double price) {
        DRINK_PRICE = price;
    }

}
