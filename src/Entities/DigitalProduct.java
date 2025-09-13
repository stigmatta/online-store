package Entities;

import Abstraction.AbstractEntities.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DigitalProduct extends Product {
    private double fileSize;

    public DigitalProduct(String name, String brand, double price, double fileSize) {
        super(name, brand, price);
        this.fileSize = fileSize;
    }

}
