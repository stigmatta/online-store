package Entities;

import Abstraction.AbstractEntities.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String name, String brand, double price, double weight) {
        super(name, brand, price);
        this.weight = weight;
    }

}
