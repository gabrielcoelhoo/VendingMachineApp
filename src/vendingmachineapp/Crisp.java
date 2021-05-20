/*
name: Gabriel Coelho Santos
lecturer: Muhammad Ibqal
date: 15th of May
project: VendingMachineApp
file: Crisp
 */
package vendingmachineapp;

/**
 *
 * @author Gabriel
 */
public class Crisp extends Product {
    //crisp variables and its parameters

    public Crisp(Long idProduct, String type) {
        setIdProduct(idProduct);
        setName(type);
        setPrice(PriceOfProducts.CRISP_PRICE);
    }

}
