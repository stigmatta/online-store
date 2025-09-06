package Entities;

import Abstraction.Interfaces.Purchasable;

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

    public void deleteProduct(Purchasable item) {
        products.remove(item);
    }

    @Override
    public String toString() {
        return "Cart{products=" + products.size() + "}";
    }
}
