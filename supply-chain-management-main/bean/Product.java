package project.bean;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private int productId;

    private String name;

    private int quantity;

    private Double price;

    private Double avgRating;

    private List<Integer> ratings;

    private static int nextProductId = 1;

    public Product(String name, int quantity, Double price) {
        this.productId = nextProductId++;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.avgRating = 0.0;
        this.ratings = new ArrayList<>();
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void decreaseQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRatting) {
        this.avgRating = avgRatting;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void addRatting(Integer rating) {
        this.ratings.add(rating);
    }

    @Override
    public String toString() {
        return "Product{  " +
                "  productId=" + productId +
                ",   name='" + name + '\'' +
                ",   quantity=" + quantity +
                ",   price=" + price +
                ",   avgRating=" + avgRating +
                ",   ratings=" + ratings +
                '}';
    }
}
