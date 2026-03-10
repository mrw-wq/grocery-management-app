package com.group4.groceryup_clean.utils;

import com.group4.groceryup_clean.models.OrderItem;
import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private List<OrderItem> cartItems;

    // Private constructor (part of Singleton pattern)
    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    // Add an item (Team 3 will call this when a user clicks 'Add to Cart')
    public void addItem(OrderItem item) {
        cartItems.add(item);
    }

    public List<OrderItem> getCartItems() {
        return cartItems;
    }

    // Calculate the total for the Checkout screen
    public double getTotalPrice() {
        double total = 0;
        for (OrderItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}