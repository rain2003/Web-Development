package project.service;

import project.bean.Application;
import project.bean.Product;

public class ProductRating implements Rating{

    @Override
    public void calculateRating(int productId) {
        Product product = Application.inventory.get(productId);
        if (product == null) {
            throw new IllegalArgumentException("Given product doesn't exist in inventory");
        }
        double sum = 0;
        for (int rating : product.getRatings()) {
            sum += rating;
        }
        if (product.getRatings().size() > 0) {
            product.setAvgRating(sum / product.getRatings().size());
        }
    }
}
