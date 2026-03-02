package com.group4.groceryup_clean.models;

public class Category {
    private String categoryId;
    private String name;
    private String description;
    private String iconName;
    private int productCount;

    // Constructor
    public Category(String categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
        this.productCount = 0;
    }

    // Getters and Setters
    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getIconName() { return iconName; }
    public void setIconName(String iconName) { this.iconName = iconName; }

    public int getProductCount() { return productCount; }
    public void setProductCount(int productCount) { this.productCount = productCount; }

    // Helper method to increment product count
    public void incrementProductCount() {
        this.productCount++;
    }

    // Helper method to decrement product count
    public void decrementProductCount() {
        if (this.productCount > 0) {
            this.productCount--;
        }
    }
}