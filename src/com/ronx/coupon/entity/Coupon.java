package com.ronx.coupon.entity;

public class Coupon {
    private String description;
    private float discount;
    private int price;

    public Coupon(String description) {
        this.description = description;
    }

    public Coupon() {
    }

    public String getDescription() {
        return description;
    }
}
