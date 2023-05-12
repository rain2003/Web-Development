package project.bean;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User {
    private int sellerId;

    private double avgRating;

    private List<Integer> productIds;

    private static int nextSellerId = 1;

    public Seller(String name, String phoneNo, String gender, String address, int age) {
        super(name, phoneNo, gender, address, age);
        this.sellerId = nextSellerId++;
        this.avgRating = 0.0;
        this.productIds = new ArrayList<>();
    }


    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void addProductId(Integer productId) {
        this.productIds.add(productId);
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId=" + sellerId +
                ", avgRating=" + avgRating +
                ", productIds=" + productIds +
                '}';
    }
}
