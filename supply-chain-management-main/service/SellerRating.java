package project.service;

import project.bean.Application;
import project.bean.Seller;

public class SellerRating implements Rating{

    @Override
    public void calculateRating(int sellerId) {
        Seller seller = Application.sellers.get(sellerId);
        if (seller == null) {
            throw new IllegalArgumentException("Given seller doesn't exist in list of sellers");
        }
        double sum = 0.0;
        for (int productId : seller.getProductIds()) {
            sum += Application.inventory.get(productId).getAvgRating();
        }

        if (seller.getProductIds().size() > 0) {
            seller.setAvgRating(sum / seller.getProductIds().size());
        }

    }
}
