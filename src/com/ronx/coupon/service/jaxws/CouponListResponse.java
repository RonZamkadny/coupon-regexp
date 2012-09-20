
package com.ronx.coupon.service.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "couponListResponse", namespace = "http://service.coupon.ronx.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "couponListResponse", namespace = "http://service.coupon.ronx.com/")
public class CouponListResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.ronx.coupon.entity.Coupon> _return;

    /**
     * 
     * @return
     *     returns List<Coupon>
     */
    public List<com.ronx.coupon.entity.Coupon> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.ronx.coupon.entity.Coupon> _return) {
        this._return = _return;
    }

}
