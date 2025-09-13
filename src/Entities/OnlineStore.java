package Entities;

import Abstraction.Interfaces.Purchasable;
import Enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class OnlineStore {
    private final static ArrayList<User> users = new ArrayList<>();
    @Setter
    @Getter
    private static String storeName;
    @Setter
    @Getter
    private static int storeId;

    static {
        storeName = "Online Store";
        storeId = 1001;
        System.out.println("Online Store initialized: " + storeName + " (ID: " + storeId + ")");

        initializeTestData();
        double sum = getAllProductsCount();
        System.out.println("All products count: " + sum);
        Cart cart = users.getFirst().getCarts().getFirst();
        purchaseAll(cart);

        Purchasable product = cart.getProduct(99);
        System.out.println("Product`s price: "+ product.getPrice());
    }

    public static void setup(){
        System.out.println("Setup started");
    }

    public static void purchaseAll(Cart cart) {
        if (cart == null || cart.products().isEmpty()) {
            System.out.println("No items to purchase.");
            return;
        }
        ArrayList<Purchasable> items = cart.products();

        double totalAmount = 0;

        for (Purchasable item : items) {
            if (item != null) {
                totalAmount += item.getPrice();
                cart.deleteProduct(item);
                System.out.println("✓ Purchase successful!");
            }
        }

        System.out.println("\n=== Purchase Summary ===");
        System.out.println("Total items: " + items.size());
        System.out.println("Total amount: $" + totalAmount);
        System.out.println("=======================\n");
    }

    public static double getAllProductsCount() {
        double total = 0;
        ArrayList<Cart> userCarts;
        for (User user : users) {
            userCarts = user.getCarts();
            total += getCartsCount(userCarts);
        }
        return total;
    }

    public static double getCartsCount(ArrayList<Cart> carts) {
        if (carts == null) {
            return 0;
        }
        return carts.stream()
                .flatMap(cart -> cart.products().stream())
                .mapToDouble(Purchasable::getPrice)
                .sum();
    }

    public void addUser(User user) {
        if (user != null) {
            users.add(user);
            System.out.println("User added to store: " + user.getName());
        }
    }

    public void removeUser(User user) {
        if (users.remove(user)) {
            System.out.println("User removed from store: " + user.getName());
        }
    }

    public ArrayList<User> getUsers() {
        return new ArrayList<>(users);
    }

    private static void initializeTestData() {
        Purchasable physical1 = new PhysicalProduct("Laptop", "Dell", 999.99, 2.5);
        Purchasable physical2 = new PhysicalProduct("Smartphone", "Samsung", 699.99, 0.2);
        Purchasable digital1 = new DigitalProduct("Photo Editor Pro", "Adobe", 199.99, 250.5);
        Purchasable digital2 = new DigitalProduct("E-Book: Java Programming", "TechBooks", 49.99, 15.2);

        Cart cart1 = new Cart();
        cart1.addProduct(physical1);
        cart1.addProduct(digital1);

        Cart cart2 = new Cart();
        cart2.addProduct(physical2);
        cart2.addProduct(digital2);

        User user1 = new User("User1");
        user1.addCart(cart1);

        User user2 = new User("User2");
        user2.addCart(cart2);

        users.add(user1);
        users.add(user2);

        System.out.println("Test data initialized with " + users.size() + " users");

        Order order = new Order();
        order.setPrice(15.2);
        order.setOrderDateTime(LocalDateTime.now());
        order.setCustomer(user1);
        order.setProducts(new ArrayList<>(Arrays.asList(physical1, digital2)));
        order.setPaymentMethod(PaymentMethod.Visa);
        System.out.println(order);

    }

    @Override
    public String toString() {
        return storeName + " - " + users.size() + " users, " + getAllProductsCount() + " total products";
    }
}