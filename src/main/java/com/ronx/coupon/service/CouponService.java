package com.ronx.coupon.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService (
        name = "CouponWS",
        targetNamespace = "http://couponws"
)
public interface CouponService {

    @WebMethod  (
            operationName = "list"
    )
    public List<String> list();
}
