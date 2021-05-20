/*
name: Gabriel Coelho Santos
lecturer: Muhammad Ibqal
date: 15th of May
project: VendingMachineApp
file: Checking
 */
package vendingmachineapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Gabriel
 */
public class CheckingData {

    //this is a class to verify if input attends all criteria from the Muhammad
    //Ibqal documentaion.
    public static boolean CorrectInput(String[] items, Set<Product> displayedProducts, List<Product> shoppList, StringBuilder message) {
        //maximum of items per person is 5
        if (items.length > 5) {
            message.append("the maximum numbers of item per person is 5");
            return false;
        }
        if (shoppList.size() > 5) {
            message.append("The selection of items must not exceed 5");
            return false;
        }
        List<Long> idsDisplayed = getIdsDisplayed(displayedProducts);

        //vaidation to check if there are letters
        for (String item : items) {
            if (!item.matches("^[0-9]+")) {
                message.append("You have entered a wrong input");
                return false;
            }
            //validation if the item selected exists on display
            if (!idsDisplayed.contains(Long.valueOf(item))) {
                message.append("The item of code: ").append(item).append("is no longer available");
                return false;
            }
            //validation if the item has already been chosen
            if (isAlreadyChosen(shoppList, item)) {
                message.append("The item of code: ").append(item).append(" has already been chosen");
                return false;
            }
        }

        return true;
    }

    //method get to see all ids on display
    public static List<Long> getIdsDisplayed(Set<Product> displayedProducts) {
        List<Long> ids = new ArrayList<>();

        for (Product product : displayedProducts) {
            ids.add(product.getIdProduct());
        }

        return ids;
    }

//method to check if an item is available
    private static boolean isAlreadyChosen(List<Product> list, String item) {
        for (Product product : list) {
            if (product.getIdProduct().toString().equals(item)) {
                return true;
            }
        }

        return false;
    }

}
