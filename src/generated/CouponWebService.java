
package generated;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CouponWebService", targetNamespace = "http://service.coupon.ronx.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CouponWebService {


    /**
     * 
     * @return
     *     returns java.util.List<generated.Coupon>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "couponList", targetNamespace = "http://service.coupon.ronx.com/", className = "generated.CouponList")
    @ResponseWrapper(localName = "couponListResponse", targetNamespace = "http://service.coupon.ronx.com/", className = "generated.CouponListResponse")
    @Action(input = "http://service.coupon.ronx.com/CouponWebService/couponListRequest", output = "http://service.coupon.ronx.com/CouponWebService/couponListResponse")
    public List<Coupon> couponList();

}