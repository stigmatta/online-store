package Entities;

import Abstraction.Interfaces.Purchasable;
import Enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
public class Order {
    PaymentMethod paymentMethod;
    LocalDateTime orderDateTime;
    double price;
    User customer;
    ArrayList<Purchasable> products;

    @Override
    public String toString() {
        return String.format("Price: %f%n Payment method: %s%n" +
                        " Customer: %s%n List of products: %s%n Order time: %s%n",
                price, paymentMethod, customer.toString(),
                products.toString(), orderDateTime.toString());
    }
}
