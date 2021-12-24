package com.practice.badgeapp.enums;

public enum ImageCategory {
    PNG("png"),
    JPG("jpg"),
    SVG("svg");


    private final String value;


    ImageCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
