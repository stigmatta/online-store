package Entities;

public class Product {
    private String name;
    private String brand;
    private double price;

    public Product(String name, String brand) {
        this(name, brand, 0.0);
    }

    public Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Product " + name + " is being removed from memory.");
        super.finalize();
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', brand='" + brand + "', price=" + price + "}";
    }
}
