package com.ronx.coupon.service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService(
        portName = "CouponWSPortName",
        serviceName = "CouponWS",
        endpointInterface = "com.ronx.coupon.service.CouponService",
        targetNamespace = "http://couponws"
)
public class CouponServiceImpl implements CouponService {

    @Override
    public List<String> list() {
        return null;
    }

//    public static void main(String[] args) {
//        Endpoint.publish("http://localhost:8888/WS/coupon", new CouponServiceImpl());
//    }

}
