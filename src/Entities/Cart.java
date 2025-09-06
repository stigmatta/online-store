package Entities;

import Entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private ArrayList<Product> products;

    public Cart() {
        this(new ArrayList<>());
    }

    // Full constructor
    public Cart(ArrayList<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public Product getProduct(int index) {
        return products.get(index);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(int index) {
        products.remove(index);
    }

    public int getSize() {
        return products.size();
    }

    @Override
    public String toString() {
        return "Cart{products=" + products.size() + "}";
    }
}
