package Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class User {
    @Setter
    private String name;
    private final int id;
    private final ArrayList<Cart> carts;

    public User(String name) {
        this(name, (int) (Math.random() * 100) + 1);
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.carts = new ArrayList<>();
    }

    public Cart getCart(int index) {
        return carts.get(index);
    }

    public void addCart(Cart cart) {
        carts.add(cart);
    }

    public void deleteCart(int index){
        carts.remove(index);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
