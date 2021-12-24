package com.practice.badgeapp.enums;

public enum UserRole {
    USER("US", "User"),
    ADMIN("AD", "Admin");


    private final String key;
    private final String value;

    UserRole(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
