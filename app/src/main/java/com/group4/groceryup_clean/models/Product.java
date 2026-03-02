package com.group4.groceryup_clean.models;

public class Product {
    private String productId;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;  // This is your INVENTORY!
    private String categoryId;
    private String imageUrl;
    private String barcode;
    private long lastUpdated;

    // Constructor
    public Product(String productId, String name, double price, int stockQuantity, String categoryId) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.categoryId = categoryId;
        this.lastUpdated = System.currentTimeMillis();
    }

    // Getters and Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }

    public long getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(long lastUpdated) { this.lastUpdated = lastUpdated; }

    // Helper methods
    public boolean isInStock() {
        return stockQuantity > 0;
    }

    public void reduceStock(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
            lastUpdated = System.currentTimeMillis();
        }
    }
}