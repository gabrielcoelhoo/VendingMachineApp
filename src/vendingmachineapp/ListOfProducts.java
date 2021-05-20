/*
name: Gabriel Coelho Santos
lecturer: Muhammad Ibqal
date: 15th of May
project: VendingMachineApp
file: LoadImpl
 */
package vendingmachineapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class ListOfProducts implements LoadInterface {

    //list with different categories in Vending Machine
    public List<Product> itemsInMachine(String productName) {
        if (productName.equalsIgnoreCase("Chocolate")) {
            return ChocolateItems();
        } else if (productName.equalsIgnoreCase("Drink")) {
            return DrinkItems();
        } else {
            return CrispItems();
        }
    }

//creation of 25 items type: chocolate 
//ids from 01 to 25  
    private List<Product> ChocolateItems() {
        List<Product> chocolates = new ArrayList<>();
        Long IDProduct = 1L;
        for (int i = 1; i <= 5; i++) {
            chocolates.add(new Chocolate(IDProduct, "Ferrero Rocher"));
            IDProduct++;
        }

        for (int i = 1; i <= 5; i++) {
            chocolates.add(new Chocolate(IDProduct, "Lindt & Sprüngli"));
            IDProduct++;
        }

        for (int i = 1; i <= 5; i++) {
            chocolates.add(new Chocolate(IDProduct, "Ghirardelli"));
            IDProduct++;
        }

        for (int i = 1; i <= 5; i++) {
            chocolates.add(new Chocolate(IDProduct, "Hershey's"));
            IDProduct++;
        }

        for (int i = 1; i <= 5; i++) {
            chocolates.add(new Chocolate(IDProduct, "Toblerone"));
            IDProduct++;
        }
        return chocolates;
    }

//creation of 25 items type: drink 
//ids from 26 to 50   
    private List<Product> DrinkItems() {
        List<Product> drinks = new ArrayList<>();
        Long IDProduct = 26L;
        for (int i = 1; i <= 5; i++) {
            drinks.add(new Drink(IDProduct, "Fanta Piña Colada"));
            IDProduct++;
        }

        for (int i = 1; i <= 5; i++) {
            drinks.add(new Drink(IDProduct, "Coca-Cola Cinnamon"));
            IDProduct++;
        }

        for (int i = 1; i <= 5; i++) {
            drinks.add(new Drink(IDProduct, "Crush Pineapple"));
            IDProduct++;
        }

        for (int i = 1; i <= 5; i++) {
            drinks.add(new Drink(IDProduct, "Mug Cream Soda"));
            IDProduct++;
        }

        for (int i = 1; i <= 5; i++) {
            drinks.add(new Drink(IDProduct, "Mtn Dew Voltage"));
            IDProduct++;
        }
        return drinks;
    }

//creation of 25 items type: crisp 
//ids from 51 to 75        
    private List<Product> CrispItems() {
        List<Product> crisps = new ArrayList<>();
        Long IDProduct = 51L;
        for (int i = 1; i <= 5; i++) {
            crisps.add(new Crisp(IDProduct, "Cheese & onion Walkers."));
            IDProduct++;
        }

        for (int i = 1; i <= 5; i++) {
            crisps.add(new Crisp(IDProduct, "Ready salted Hula Hoops."));
            IDProduct++;
        }

        for (int i = 1; i <= 5; i++) {
            crisps.add(new Crisp(IDProduct, "Salt & vinegar McCoy's."));
            IDProduct++;
        }

        for (int i = 1; i <= 5; i++) {
            crisps.add(new Crisp(IDProduct, "Chilli heatwave Doritos."));
            IDProduct++;
        }

        for (int i = 1; i <= 5; i++) {
            crisps.add(new Crisp(IDProduct, "Bacon Frazzles"));
            IDProduct++;
        }

        return crisps;
    }

}
