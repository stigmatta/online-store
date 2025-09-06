package Entities;

import Abstraction.AbstractEntities.Product;

public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String name, String brand, double price, double weight) {
        super(name, brand, price);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
