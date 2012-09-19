import com.ronx.coupon.entity.CouponSite;
import com.ronx.coupon.service.CouponService;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import javax.xml.ws.Endpoint;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Core {

    public static void main(String[] args) {

        CouponSite pokupon = null;
        try {
            pokupon = new CouponSite(new PropertiesConfiguration("properties/pokupon.properties"));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        int numConnections = 1000;

        CouponService couponService = new CouponService();
        couponService.setCouponSite(pokupon);

        ExecutorService threads = Executors.newFixedThreadPool(numConnections);

        Endpoint endpoint = Endpoint.publish("http://localhost:8888/WS/coupon", couponService);

        endpoint.setExecutor(threads);

        return;
    }

}
