package Entities;

import Abstraction.Interfaces.Purchasable;
import Exceptions.ProductNotFoundException;

import java.util.ArrayList;

public record Cart(ArrayList<Purchasable> products) {
    public Cart() {
        this(new ArrayList<>());
    }

    @Override
    public ArrayList<Purchasable> products() {
        return new ArrayList<>(products);
    }

    public void addProduct(Purchasable product) {
        products.add(product);
    }

    public void deleteProduct(Purchasable product) {
        products.remove(product);
    }

    public Purchasable getProduct(int index) throws ProductNotFoundException {
        if (index < 0 || index >= products.size()) {
            throw new ProductNotFoundException();
        }
        return products.get(index);
    }

    @Override
    public String toString() {
        return "Cart{products=" + products.size() + "}";
    }
}
