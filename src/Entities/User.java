package Entities;

import java.util.ArrayList;
import java.util.UUID;

import static java.lang.Math.random;

public class User {
    private String name;
    private final int id;
    private ArrayList<Cart> carts;

    public User(String name) {
        this(name, (int) (Math.random() * 100) + 1);
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.carts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Cart> getCarts() {
        return carts;
    }

    public Cart getCart(int index) {
        return carts.get(index);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCart(Cart cart) {
        carts.add(cart);
    }

    public void deleteCart(int index){
        carts.remove(index);
    }
}
