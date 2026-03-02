package com.group4.groceryup_clean.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private String userId;
    private List<OrderItem> items;
    private double subtotal;
    private double tax;
    private double totalAmount;
    private String paymentMethod;  // "Cash", "Card", "Mobile Money"
    private String paymentStatus;   // "pending", "paid", "failed"
    private String orderStatus;     // "placed", "processing", "completed", "cancelled"
    private long orderDate;
    private String deliveryAddress;

    // Constructor
    public Order(String orderId, String userId) {
        this.orderId = orderId;
        this.userId = userId;
        this.items = new ArrayList<>();
        this.orderDate = System.currentTimeMillis();
        this.orderStatus = "placed";
        this.paymentStatus = "pending";
        this.subtotal = 0.0;
        this.tax = 0.0;
        this.totalAmount = 0.0;
    }

    // Calculate total from all items
    public void calculateTotal() {
        subtotal = 0;
        for (OrderItem item : items) {
            subtotal += item.getSubtotal();
        }
        tax = subtotal * 0.1; // 10% tax (adjust as needed)
        totalAmount = subtotal + tax;
    }

    // Add item to order
    public void addItem(OrderItem item) {
        items.add(item);
        calculateTotal();
    }

    // Remove item from order
    public void removeItem(OrderItem item) {
        items.remove(item);
        calculateTotal();
    }

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) {
        this.items = items;
        calculateTotal();
    }

    public double getSubtotal() { return subtotal; }
    public double getTax() { return tax; }
    public double getTotalAmount() { return totalAmount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

    public long getOrderDate() { return orderDate; }
    public void setOrderDate(long orderDate) { this.orderDate = orderDate; }

    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
}