/*
name: Gabriel Coelho Santos
lecturer: Muhammad Ibqal
date: 15th of May
project: VendingMachineApp
file: Drink
 */
package vendingmachineapp;

/**
 *
 * @author Gabriel
 */
public class Drink extends Product {
    //Drink variables and its parameters

    public Drink(Long idProduct, String type) {
        setIdProduct(idProduct);
        setName(type);
        setPrice(PriceOfProducts.DRINK_PRICE);
    }

}
