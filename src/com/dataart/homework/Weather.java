package com.dataart.homework;

public enum Weather {
    FROST("Fur Coat", "Warm Boots"),
    COOL("Jacket", "Shoes"),
    WARM("T-shirt", "Shorts"),
    HOT("Cap", "Slippers");

    private String top;
    private String bottom;
    private int index;

    Weather(String top, String bottom) {
        this.top = top;
        this.bottom = bottom;
        this.index = index;
    }

    public String[] getCloses() {
        String[] str = {top, bottom};
        return str;
    }

    public int getIndex() {
        return index;
    }

    public String toString() {
        return "[" + top + "]" + ", " + "[" + bottom + "]";
    }
}
