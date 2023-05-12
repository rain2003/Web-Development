package project.bean;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends User {
    private int buyerId;

    private List<Integer> productIds;

    private static int nextBuyerId = 1;

    public Buyer(String name, String phoneNo, String gender, String address, int age) {
        super(name, phoneNo, gender, address, age);
        this.buyerId = nextBuyerId++;
        this.productIds = new ArrayList<>();
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void addProductId(Integer productId) {
        this.productIds.add(productId);
    }

    @Override
    public String toString() {
        return "Buyer{  " +
                "buyerId=  " + buyerId +
                ", productIds=  " + productIds +
                '}';
    }
}
