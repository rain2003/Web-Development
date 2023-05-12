package project.bean;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static Map<Integer, Product> inventory = new HashMap<>();

    public static Map<Integer, Buyer> buyers = new HashMap<>();

    public static Map<Integer, Seller> sellers = new HashMap<>();

    public Application() {

        Product product1 = new Product("Shoes", 10, 100.0);
        inventory.put(product1.getProductId(), product1);

        Product product2 = new Product("Cap", 20, 50.0);
        inventory.put(product2.getProductId(), product2);

        Product product3 = new Product("Watch", 6, 150.0);
        inventory.put(product3.getProductId(), product3);

        Product product4 = new Product("Phone", 20, 2000.0);
        inventory.put(product4.getProductId(), product4);

        Product product5 = new Product("Keyboard", 5, 500.0);
        inventory.put(product5.getProductId(), product5);

        Product product6 = new Product("Monitor", 15, 2000.0);
        inventory.put(product6.getProductId(), product6);
    }
}
