/*
name: Gabriel Coelho Santos
lecturer: Muhammad Ibqal
date: 15th of May
project: VendingMachineApp
file: VendingMachineApp
 */
package vendingmachineapp;

//imports to utilizes advanced features of Java
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author Gabriel
 */
public class VendingMachineApp {
    //declaration of Static variables
    static LoadInterface load;
    static List<Product> chocolates;
    static List<Product> crisps;
    static List<Product> drinks;
    static List<SetupOfProducts> ordersList;
    static List<Product> shoppList;
    static Set<Product> displayedProducts;

//initialisation of static variables
    static {
        load = new ListOfProducts();
        chocolates = load.itemsInMachine("Chocolate");
        crisps = load.itemsInMachine("Crisp");
        drinks = load.itemsInMachine("Drink");
        ordersList = new ArrayList<>();
        shoppList = new ArrayList<>();
        displayedProducts = new HashSet<>();
    }

    public static void main(String[] args) {
        //method initialise to display a menu at the beggining of program
        initialize();

        //method scanner to save users input
        //declaration and initialisation of items inside a list
        Scanner s = new Scanner(System.in);
        String[] items = null;

        while ((chocolates.size() + crisps.size() + drinks.size()) > 0) {
            //checking the size of my order which must be in maximum 5
            while (shoppList.size() < 5) {
                System.out.println("Enter the number besides the item desired: ");

                items = s.nextLine().split(" ");

                // special functions when enter as admin
                if (items[0].equals("admin")) {
                    MenuOfAdmin(s);
                    reset();
                    continue;
                }

                // press 0 to exit of program
                if (items.length == 1 && items[0].equals("0")) {
                    reStock();
                    reset();
                    //I set this code below in case when 0
                    //is pressed the program quit
                    //System.exit(0);
                    continue;
                }

                //validation of input throughout while loop and if statement
                boolean isValid = false;
                // Valid the items
                while (!isValid) {
                    StringBuilder message = new StringBuilder();
                    if (!CheckingData.CorrectInput(items, displayedProducts, shoppList, message)) {
                        System.out.println(message);
                        break;
                    } else {
                        isValid = true;
                        //decrease in stock and 
                        //refresh all list of products
                        stockRemoval(items);
                        pay(s);
                        s = new Scanner(System.in);
                    }

                }
            }

        }
    }

    //menu in the beginning of program
    private static void initialize() {
        displayedProducts = new HashSet<>();
        showMenu();
        System.out.println("");
        System.out.println("OPTIONS:");
        System.out.println("Press 0 to leave.");

    }

    //items displayed in a vending machine
    private static void showMenu() {
        System.out.println("Availability of items: \n");

        List<Product> products = new ArrayList<>();

//creation of objects with prices on the side.
        for (int i = 1; i <= 9; i++) {
            switch (i) {
                case 1:
                case 2:
                case 3: {
                    System.out.println("CHOCOLATES PRICE: $" + PriceOfProducts.CHOCOLATE_PRICE);
                    products = chocolates;
                    break;
                }
                case 4:
                case 5:
                case 6: {
                    System.out.println("DRINKS PRICE: $" + PriceOfProducts.DRINK_PRICE);
                    products = drinks;
                    break;
                }

                case 7:
                case 8:
                case 9: {
                    System.out.println("CRISPS PRICE: $" + PriceOfProducts.CRISP_PRICE);
                    products = crisps;
                    break;
                }

            }
            //method to generate ramdonly products in vending machine
            getRandomTypes(products);

        }

    }

    //method to remove items from stock
    private static void stockRemoval(String[] items) {
        for (String item : items) {
            Long itemId = Long.valueOf(item);
            if (itemId <= 25) {
                Product product = getProduct(displayedProducts, itemId);
                shoppList.add(product);
                RemoveFromStock(chocolates, product);
            } else if (itemId > 25 && itemId < 51) {
                Product product = getProduct(displayedProducts, itemId);
                shoppList.add(product);
                RemoveFromStock(drinks, product);
            } else {
                Product product = getProduct(displayedProducts, itemId);
                shoppList.add(product);
                RemoveFromStock(crisps, product);
            }
        }
    }

    //method to pay the bill and v validation of values
    private static void pay(Scanner s) {
        String totalBill = billManagement();

        System.out.println("Type the value of your bill to be paid");

        String valueFromUser = s.next();

        if (valueFromUser.equals("0")) {
            reset();
            return;
        }
//checking of input and allowance by correct values
        boolean isNotValid = true;
        while (isNotValid) {
            if (!String.valueOf(totalBill).equals(valueFromUser)) {
                System.out.println("Type a correct value");
                s.nextLine();
                valueFromUser = s.next();
            } else {
                isNotValid = false;
            }

        }

        PaymentSuccessful(Double.valueOf(totalBill));

    }

    //method to manage all bills specifications
    private static String billManagement() {
        DecimalFormat fmt = new DecimalFormat("0.00");
        double totalBill = 0d;
        int countChocolates = 0;
        int countDrinks = 0;
        int countCrisps = 0;
        double totalDiscount = 0d;
        System.out.println("You have selected products: ");
        for (Product product : shoppList) {
            if (product instanceof Chocolate) {
                countChocolates++;
            } else if (product instanceof Drink) {
                countDrinks++;
            } else {
                countCrisps++;
            }
            totalBill += product.getPrice();
            System.out.println(product.getName() + " €" + product.getPrice());
        }
        totalDiscount = applyDiscount(totalBill, countChocolates, countDrinks, countCrisps, totalDiscount);

        totalBill -= totalDiscount;
        System.out.println("The total bill is €" + fmt.format(totalBill));
        System.out.println("The discount applied is €" + fmt.format(totalDiscount) + " from your bill");
        return fmt.format(totalBill);
    }

    //method to apply discount in given examples as demonstrated in the documentation
    private static double applyDiscount(double totalBill, int countChocolates, int countDrinks, int countCrisps,
            double totalDiscount) {

        if (countChocolates >= 2 && countCrisps >= 2) {
            return totalDiscount += 0.10 * totalBill;
        }

        if (countChocolates >= 2 && countDrinks >= 2) {
            return totalDiscount += 0.10 * totalBill;
        }

        if (countDrinks >= 2 && countCrisps >= 2) {
            return totalDiscount += 0.10 * totalBill;
        }
        return totalDiscount;
    }

    //method to finish payment
    private static void PaymentSuccessful(double totalBill) {
        ordersList.add(new SetupOfProducts(shoppList, totalBill));
        shoppList = new ArrayList<>();
        reset();
    }

//method to reset and start a new operation
    private static void reset() {
        Refactor();//clear the old menu
        shoppList = new ArrayList<>();
        initialize();
    }
//method to re-stock items sold out

    private static void reStock() {
        shoppList.forEach((product) -> {
            if (product instanceof Chocolate) {
                chocolates.add(product);
            } else if (product instanceof Drink) {
                drinks.add(product);
            } else {
                crisps.add(product);
            }
        });
    }

    //method to search product inside stock
    public static Product getProduct(Set<Product> displayedProducts, Long idProduct) {
        Product productFind = null;
        for (Product product : displayedProducts) {
            if (Objects.equals(product.getIdProduct(), idProduct)) {
                productFind = product;
                break;
            }
        }
        return productFind;
    }

//display ramdonly products on shelf
    private static void getRandomTypes(List<Product> products) {

        List<Product> elements = new ArrayList<>();
        Random generator = new Random();

        while (elements.size() < products.size()) {
            Product product = products.get(generator.nextInt(products.size()));
            if (elements.size() == 5) {
                break;
            }
            if (displayedProducts.add(product)) {
                elements.add(product);
            }
        }

        elements.forEach((product) -> {
            System.out.println(product.getName() + ":" + product.getIdProduct());
        });

        System.out.println("");

    }

    //the development of a special menu for administrators
    private static void MenuOfAdmin(Scanner s) {
        double total = 0;
        AdministrationFunctions();
        String option = s.nextLine();
        boolean admin = true;

        while (admin) {
            if (option.equals("1")) {
                System.out.println("These are the items sold.");
                for (SetupOfProducts order : ordersList) {
                    total += order.getTotal();
                    for (Product product : order.getProduct()) {
                        System.out.println(product.getName() + product.getPrice());

                    }
                }
                System.out.println("total price of this bill " + total);
            } else if (option.equals("2")) {
                //the development of this part still in progress
            }

            System.out.println("If you want to cancel this operation, press yes");
            option = s.nextLine();

            if (option.equalsIgnoreCase("yes")) {
                admin = false;
            } else {
                AdministrationFunctions();
                s.nextLine();
            }
        }
    }

    //menu for admin operations
    private static void AdministrationFunctions() {
        System.out.println("Welcome Admin, there are two options to choose "
                + "\n type 1 or 2 to see more details");
        System.out.println("1 - Details of items sold");
        System.out.println("2 - Modification in values of products");
    }

    //taking the product out from stock
    private static void RemoveFromStock(List<Product> productsStock, Product product) {
        productsStock.remove(product);
    }

    //refresh a page with new vending machine
    private static void Refactor() {
        for (int i = 0; i < 35; i++) {
            System.out.println("");
        }
        System.out.println("Welcome to Vending Machine");
    }

}
