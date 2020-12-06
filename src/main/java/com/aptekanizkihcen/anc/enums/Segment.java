package com.aptekanizkihcen.anc.enums;

public enum Segment {
    GENERAL("GENERAL"),
    VIP("VIP");

    private String segment;

    Segment(String segment) {
        this.segment = segment;
    }

    public String getSegment() {
        return segment;
    }
}
