package com.ronx.coupon.service;

import com.ronx.coupon.entity.Coupon;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(
        name = "CouponWebService"
)
public interface CouponWebServiceInterface {
    @WebMethod()
    public List<Coupon> couponList();
}
