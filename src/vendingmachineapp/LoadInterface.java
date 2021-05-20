/*
name: Gabriel Coelho Santos
lecturer: Muhammad Ibqal
date: 15th of May
project: VendingMachineApp
file: Load
 */
package vendingmachineapp;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface LoadInterface {
    //list created to save products inside of itemsMachine storage
    List<Product> itemsInMachine(String productName);
}
