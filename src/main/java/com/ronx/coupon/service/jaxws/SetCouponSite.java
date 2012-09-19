
package com.ronx.coupon.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "setCouponSite", namespace = "http://service.coupon.ronx.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setCouponSite", namespace = "http://service.coupon.ronx.com/")
public class SetCouponSite {

    @XmlElement(name = "arg0", namespace = "")
    private com.ronx.coupon.entity.CouponSite arg0;

    /**
     * 
     * @return
     *     returns CouponSite
     */
    public com.ronx.coupon.entity.CouponSite getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.ronx.coupon.entity.CouponSite arg0) {
        this.arg0 = arg0;
    }

}
