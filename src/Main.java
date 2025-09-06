import Entities.OnlineStore;
import Entities.Product;

public class Main {
    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();
        {
            Product tempProduct = new Product("Test", "Brand", 100.0f);
            tempProduct = null;
        }
        System.gc(); // testing gc
    }
}