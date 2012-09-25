package com.ronx.coupon.server;

import com.ronx.coupon.entity.CouponSite;
import com.ronx.coupon.service.CouponWebService;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import javax.management.*;
import javax.xml.ws.Endpoint;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CouponServer implements CouponServerMBean   {

    private Map<CouponSite, PropertiesConfiguration> sitePropertiesMap = new HashMap<>();

    private static final int availableProcessors = Runtime.getRuntime().availableProcessors();

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(availableProcessors, availableProcessors, 10L, TimeUnit.NANOSECONDS,
            new ArrayBlockingQueue<Runnable>(availableProcessors, true),
            new ThreadPoolExecutor.CallerRunsPolicy());
    ;
    private MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
    private Endpoint endpoint;
    private CouponWebService couponWebService = new CouponWebService();

    public CouponServer() {
        try {
            mBeanServer.registerMBean(this, new ObjectName("com.ronx.coupon.server:type=CouponServerMBean"));
        } catch (   MalformedObjectNameException    |
                InstanceAlreadyExistsException  |
                MBeanRegistrationException  |
                NotCompliantMBeanException e) {
            e.printStackTrace();
        }
        executor.prestartAllCoreThreads();

        //TODO: replace with pattern Factory or Builder
        {
            CouponSite pokupon = new CouponSite();
            PropertiesConfiguration propertiesConfiguration = null;
            try {
                propertiesConfiguration = new PropertiesConfiguration("properties/pokupon.properties");
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
            sitePropertiesMap.put(pokupon, propertiesConfiguration);
            couponWebService.setCouponSite(pokupon);
        }
    }

    public static void main(String[] args) {
        CouponServer couponServer = new CouponServer();
        couponServer.start();
        return;
    }

    @Override
    public void stop()  {
        endpoint.stop();
    }

    @Override
    public void reloadServerProperties() {
        Iterator<PropertiesConfiguration> iterator = sitePropertiesMap.values().iterator();
        while(iterator.hasNext())   {
            iterator.next().reload();
        }
    }

    @Override
    public void start() {
        endpoint = Endpoint.publish("http://localhost:8888/WS/coupon", couponWebService);
        endpoint.setExecutor(executor);
    }
}
