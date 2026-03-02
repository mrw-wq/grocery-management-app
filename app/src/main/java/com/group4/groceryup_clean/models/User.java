package com.group4.groceryup_clean.models;

public class User {
    private String userId;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String role;
    private long createdAt;

    // Constructor
    public User(String userId, String email, String fullName, String role) {
        this.userId = userId;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.createdAt = System.currentTimeMillis();
    }

    // Getters and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }
}