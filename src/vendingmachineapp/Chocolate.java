/*
name: Gabriel Coelho Santos
lecturer: Muhammad Ibqal
date: 15th of May
project: VendingMachineApp
file: Chocolate
 */
package vendingmachineapp;

/**
 *
 * @author Gabriel
 */
public class Chocolate extends Product{
    //chocolate variables and its parameters
    public Chocolate(Long id, String type) {
		setIdProduct(id);
		setName(type);
		setPrice(PriceOfProducts.CHOCOLATE_PRICE);
	}

   
}
