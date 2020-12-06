package com.aptekanizkihcen.anc.enums;

public enum FamilyStatus {
    NOT_MARRIED("NOT_MARRIED"),
    MARRIED("MARRIED");

    private String familyStatus;

    FamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }
}
