package com.ronx.coupon.service;


import com.ronx.coupon.entity.Coupon;
import com.ronx.coupon.entity.CouponSite;


import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.LinkedList;
import java.util.List;


@WebService(
        portName = "CouponWebServicePortName",
        serviceName = "CouponWebService",
        endpointInterface = "com.ronx.coupon.service.CouponWebServiceInterface"
//        targetNamespace = "http://couponws"
)
public class CouponWebService implements CouponWebServiceInterface {


    private CouponSite couponSite;


    public void setCouponSite(CouponSite couponSite) {
        this.couponSite = couponSite;
    }


    public List<Coupon> couponList() {
        if (couponSite != null) {
            return couponSite.retreiveAllCoupons();
        } else  {
            return new LinkedList<>();
        }
    }


}
