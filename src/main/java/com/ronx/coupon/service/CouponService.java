package com.ronx.coupon.service;

import com.ronx.coupon.entity.Coupon;
import com.ronx.coupon.entity.CouponSite;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

@WebService(
//        portName = "CouponWSPortName",
//        serviceName = "CouponWS",
//        endpointInterface = "com.ronx.coupon.service.CouponService",
//        targetNamespace = "http://couponws"
)
public class CouponService  {

    private CouponSite couponSite;

    public void setCouponSite(CouponSite couponSite) {
        this.couponSite = couponSite;
    }

    @WebMethod(
            operationName = "list"
    )
    public List<Coupon> list() {
        if (couponSite != null) {
            return couponSite.retreiveAllCoupons();
        } else  {
            return new LinkedList<>();
        }
    }

}
