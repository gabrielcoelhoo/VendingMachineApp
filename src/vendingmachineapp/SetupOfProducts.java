/*
name: Gabriel Coelho Santos
lecturer: Muhammad Ibqal
date: 15th of May
project: VendingMachineApp
file: SetupOfProducts
 */
package vendingmachineapp;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public class SetupOfProducts {

//declaration and intialisation of private variables
    private long id;
    private List<Product> products;
    private static long idOrder = 1L;
    private double total;

//method to receive products and total price of them.
    public SetupOfProducts(List<Product> products, double total) {
        this.id = idOrder;
        this.products = products;
        this.total = total;
        idOrder++;
    }

//method of setters and getters to be aligned with encapsulation
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    Iterable<Product> getProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
