package project.service;

import project.bean.Application;
import project.bean.Product;
import project.bean.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerService {

    public List<Product> getAllProducts() {
        return new ArrayList<>(Application.inventory.values());
    }

    public List<Seller> getAllSellers() {
        return new ArrayList<>(Application.sellers.values());
    }

    public void sellProduct(Product product, int sellerId) {
        Seller seller = Application.sellers.get(sellerId);
        seller.addProductId(product.getProductId());
        Application.sellers.put(sellerId, seller);
        Application.inventory.put(product.getProductId(), product);
    }

    public void increaseProductQty(int productId, int quantity) {
        Product product = Application.inventory.get(productId);
        product.increaseQuantity(quantity);
        Application.inventory.put(productId, product);
    }

}