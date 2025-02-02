package com.example.wildanimals;

public class Feed {
    private String type;
    private double quantityPerDay;

    public Feed(String type, double quantityPerDay) {
        this.type = type;
        this.quantityPerDay = quantityPerDay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantityPerDay() {
        return quantityPerDay;
    }

    public void setQuantityPerDay(double quantityPerDay) {
        this.quantityPerDay = quantityPerDay;
    }
}

