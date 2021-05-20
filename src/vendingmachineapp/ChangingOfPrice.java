/*
name: Gabriel Coelho Santos
lecturer: Muhammad Ibqal
date: 15th of May
project: VendingMachineApp
file: ChangingOfPrice
 */
package vendingmachineapp;
/**
 *
 * @author Gabriel
 */
public interface ChangingOfPrice {
    //interface created to achieve abstraction in changing
    //of items prices
        void changeChocolatePrice(double price);
	void changeCrispPrice(double price);
	void changeDrinkPrice(double price);
}
