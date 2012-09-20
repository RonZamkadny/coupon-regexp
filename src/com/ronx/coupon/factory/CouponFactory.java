package com.ronx.coupon.factory;

import com.ronx.coupon.entity.Coupon;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CouponFactory {

    public static List<Coupon> createCoupons(List<String> list)   {
        List<Coupon> couponList = new LinkedList<>();
        Coupon coupon = null;
        for(String couponDesc : list)   {
            coupon = new Coupon(couponDesc);
            couponList.add(coupon);
        }
        return couponList;
    }

}
