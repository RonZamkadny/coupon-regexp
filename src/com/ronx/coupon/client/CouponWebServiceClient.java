package com.ronx.coupon.client;

import generated.Coupon;
import generated.CouponWebService;
import generated.CouponWebService_Service;

import javax.xml.ws.WebServiceClient;
import java.util.List;

@WebServiceClient(
//        wsdlLocation = "../out/"
)
public class CouponWebServiceClient {

    public static void main(String[] args) throws Exception {

        CouponWebService_Service generated = new CouponWebService_Service();
        CouponWebService couponService = generated.getCouponWebServicePortName();
        List<Coupon> list = couponService.couponList();
        for(Coupon coupon : list)   {
////            System.out.println(couponService.concreteCouponDesc(coupon));
        }
        return;

    }

}
