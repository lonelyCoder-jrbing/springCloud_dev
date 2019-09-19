package com.yh.builder;

public enum HairStyle {
    BALD("bald"), SHORT("short"), CURLY("curly"), LONG_STRAIGHT("long straight"), LONG_CURLY(
            "long curly");

    private String title;

    HairStyle(String title) {
        this.title = title;
    }
}
