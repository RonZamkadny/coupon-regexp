package com.ronx.coupon.entity;

import static com.ronx.coupon.utility.ConfigurationProperties.*;

import com.ronx.coupon.factory.CouponFactory;
import com.ronx.coupon.utility.CouponUtilities;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;

public class CouponSite {

    private PropertiesConfiguration configuration;
    private List<Coupon> couponList;

    public CouponSite(PropertiesConfiguration configuration) {
        this.configuration = configuration;
    }

    public List<Coupon> retreiveAllCoupons()   {
        couponList = null;
        Pattern pattern = Pattern.compile(configuration.getString(coupon_all_titles_regexp));
        try {
            couponList = CouponFactory.createCoupons(
                    CouponUtilities.readPage(new URL(configuration.getString(coupon_site_url)), pattern));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return couponList;
    }

    public CouponSite() {
    }
}
