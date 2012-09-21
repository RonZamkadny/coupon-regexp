
package generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CouponListResponse_QNAME = new QName("http://service.coupon.ronx.com/", "couponListResponse");
    private final static QName _CouponList_QNAME = new QName("http://service.coupon.ronx.com/", "couponList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CouponList }
     * 
     */
    public CouponList createCouponList() {
        return new CouponList();
    }

    /**
     * Create an instance of {@link CouponListResponse }
     * 
     */
    public CouponListResponse createCouponListResponse() {
        return new CouponListResponse();
    }

    /**
     * Create an instance of {@link Coupon }
     * 
     */
    public Coupon createCoupon() {
        return new Coupon();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CouponListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.coupon.ronx.com/", name = "couponListResponse")
    public JAXBElement<CouponListResponse> createCouponListResponse(CouponListResponse value) {
        return new JAXBElement<CouponListResponse>(_CouponListResponse_QNAME, CouponListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CouponList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.coupon.ronx.com/", name = "couponList")
    public JAXBElement<CouponList> createCouponList(CouponList value) {
        return new JAXBElement<CouponList>(_CouponList_QNAME, CouponList.class, null, value);
    }

}
