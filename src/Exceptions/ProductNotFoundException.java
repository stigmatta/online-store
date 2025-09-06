package Exceptions;

public class ProductNotFoundException extends RuntimeException  {
    public ProductNotFoundException() {
        super("Product is not found");
    }
}
