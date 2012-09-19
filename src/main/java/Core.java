import com.ronx.coupon.entity.Coupon;
import com.ronx.coupon.entity.CouponSite;
import com.ronx.coupon.utility.CouponUtilities;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.net.URL;
import java.util.List;

public class Core {

    public static void main(String[] args) {

        CouponSite pokupon = null;
        try {
            pokupon = new CouponSite(new PropertiesConfiguration("properties/pokupon.properties"));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        List<Coupon> list = pokupon.retreiveAllCoupons();

        return;
    }

}
