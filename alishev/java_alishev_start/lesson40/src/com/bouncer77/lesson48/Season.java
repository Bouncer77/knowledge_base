package com.bouncer77.lesson48;

public enum Season {
    SUMMER(30),
    AUTUMN(15),
    WINTER(-20),
    SPRING(10);

    private int avgTemperature;

    Season(int avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    public int getAvgTemperature() {
        return avgTemperature;
    }
}
