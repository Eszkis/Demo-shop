package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Popup;

public class ShoppingCart {

    List<Product> productList = new ArrayList<>();

    int userID;

    public ShoppingCart() {
    };

    public ShoppingCart(int userID) {
        this.userID = userID;
    }

    public void addToCart(Product product) {
        productList.add(product);
    }

    public void removeFromCart(Product product) {
        productList.remove(product);
    }

    public List<Product> getAllProduct() {
        return productList;
    }

    public int getSize() {
        return productList.size();
    }

    public float getTotalValue() {
        float totalValue = 0;
        for (int i = 0; i < productList.size(); i++) {
            totalValue += productList.get(i).getDefaultPrice();
        }
        return totalValue;
    }
}
