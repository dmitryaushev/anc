package com.aptekanizkihcen.anc.enums;

public enum Education {
    MIDDLE("MIDDLE"),
    HIGHER("HIGHER");

    private String education;

    Education(String education) {
        this.education = education;
    }

    public String getEducation() {
        return education;
    }
}
