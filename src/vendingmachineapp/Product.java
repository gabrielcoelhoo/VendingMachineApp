/*
name: Gabriel Coelho Santos
lecturer: Muhammad Ibqal
date: 15th of May
project: VendingMachineApp
file: Product
 */
package vendingmachineapp;

/**
 *
 * @author Gabriel
 */
public abstract class Product {

    //declaration and initialisation of private variables
    private String name;
    private Double price;
    private Long idProduct;

    public String getName() {
        return name;
    }

    //setters and getters method to maintain the program encapsulates
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idProduct == null) ? 0 : idProduct.hashCode());
        return result;
    }

    @Override
    //validation of items if they are  correct objects  passed as parameters
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        if (idProduct == null) {
            if (other.idProduct != null) {
                return false;
            }
        } else if (!idProduct.equals(other.idProduct)) {
            return false;
        }
        return true;
    }

}
