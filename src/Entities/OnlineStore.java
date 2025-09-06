package Entities;

import java.util.ArrayList;

public class OnlineStore {
    private static ArrayList<User> users = new ArrayList<>();
    private static String storeName;
    private static int storeId;

    static {
        storeName = "Online Store";
        storeId = 1001;
        System.out.println("Online Store initialized: " + storeName + " (ID: " + storeId + ")");

        initializeTestData();
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
        if (carts == null){
            return 0;
        }
        return carts.stream()
                .flatMap(cart -> cart.getProducts().stream())
                .mapToDouble(Product::getPrice)
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

    public static String getStoreName() {
        return storeName;
    }
    public static void setStoreName(String name) {
        storeName = name;
    }

    public static int getStoreId() {
        return storeId;
    }
    public static void setStoreId(int id) {
        storeId = id;
    }

    private static void initializeTestData() {
        Product p1 = new Product("Laptop", "Dell", 999.99);
        Product p2 = new Product("Smartphone", "Samsung", 699.99);
        Product p3 = new Product("Headphones", "Sony", 199.99);
        Product p4 = new Product("Mouse", "Logitech", 49.99);

        Cart cart1 = new Cart();
        cart1.addProduct(p1);
        cart1.addProduct(p3);

        Cart cart2 = new Cart();
        cart2.addProduct(p2);
        cart2.addProduct(p4);

        User user1 = new User("User1");
        user1.addCart(cart1);

        User user2 = new User("User2");
        user2.addCart(cart2);

        users.add(user1);
        users.add(user2);

        System.out.println("Test data initialized with " + users.size() + " users");

        double sum = getAllProductsCount();
        System.out.println("All products count: " + sum);
    }

    @Override
    public String toString() {
        return storeName + " - " + users.size() + " users, " + getAllProductsCount() + " total products";
    }
}