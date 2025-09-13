package Abstraction.AbstractEntities;

import Abstraction.Interfaces.Purchasable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Product implements Purchasable {
    private String name;
    private String brand;
    @Getter(onMethod_=@Override)
    @Setter(onMethod_=@Override)
    private double price;
    public Product(String name, String brand) {
        this(name, brand, 0.0);
    }

    public Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Product " + name + " is being removed from memory.");
        super.finalize();
    }

    @Override
    public String toString() {
        return "Name:" + name + "', brand='" + brand + "', price=" + price;
    }
}
