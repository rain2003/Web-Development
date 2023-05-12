package project.service;

import project.bean.Application;
import project.bean.Buyer;
import project.bean.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuyerService {

    public List<Product> getAllProducts() {
        return new ArrayList<>(Application.inventory.values());
    }

    public void buyProduct(int buyerId, int productId, int quantity) {
        Product product = Application.inventory.get(productId);
        if (product.getQuantity() >= quantity) {
            product.decreaseQuantity(quantity);
        } else {
            throw new IllegalArgumentException("Enough stock not available");
        }
        Application.inventory.put(productId, product);

        Buyer buyer = Application.buyers.get(buyerId);
        buyer.addProductId(productId);
        Application.buyers.put(buyerId, buyer);
    }

    public void putRatting(int productId, int ratting) {
        Product product = Application.inventory.get(productId);
        product.addRatting(ratting);
        Application.inventory.put(productId, product);
    }

}
