package com.practice.badgeapp.enums;

public enum AssignmentStatus {
    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    PENDING("Pending");


    private final String value;

    AssignmentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
