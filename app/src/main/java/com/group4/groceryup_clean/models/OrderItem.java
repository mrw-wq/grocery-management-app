package com.group4.groceryup_clean.models;

public class OrderItem {
    private String productId;
    private String productName;
    private int quantity;
    private double unitPrice;
    private double subtotal;

    // Constructor
    public OrderItem(String productId, String productName, int quantity, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = quantity * unitPrice;
    }

    // Getters and Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        recalculateSubtotal();
    }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        recalculateSubtotal();
    }

    public double getSubtotal() { return subtotal; }

    // Helper method
    private void recalculateSubtotal() {
        this.subtotal = this.quantity * this.unitPrice;
    }
}