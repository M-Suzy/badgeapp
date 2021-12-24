package com.practice.badgeapp.enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");


   // private final String key;
    private final String value;

    Gender(String value) {
        //this.key = key;
        this.value = value;
    }
/*
    public String getKey() {
        return key;
    }
*/
    public String getValue() {
        return value;
    }
}
