package com.aptekanizkihcen.anc.enums;

public enum Status {
    CREATED("CREATED"),
    ACTIVE("ACTIVE"),
    DELETED("DELETED");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
