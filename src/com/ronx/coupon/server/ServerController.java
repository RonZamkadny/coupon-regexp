package com.ronx.coupon.server;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class ServerController implements ServerControllerMBean  {

    private CouponServer server;

    public ServerController(CouponServer server) {
        this.server = server;
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name;
        try {
            name = new ObjectName("com.ronx.coupon.server:type=ServerController");
            mbs.registerMBean(this, name);
        } catch (   MalformedObjectNameException    |
                        InstanceAlreadyExistsException  |
                            MBeanRegistrationException  |
                                NotCompliantMBeanException e) {
            e.printStackTrace();
        }
    }

    public int getCorePoolSize() {
        return server.getExecutor().getCorePoolSize();
    }

    public void setCorePoolSize(int corePoolSize) {
        server.getExecutor().setCorePoolSize(corePoolSize);
    }

    public int getMaxPoolSize()	{
        return server.getExecutor().getMaximumPoolSize();
    }

    public void setMaxPoolSize(int maxPoolSize)	{
        server.getExecutor().setMaximumPoolSize(maxPoolSize);
    }

    public int getActiveThreads() {
        return server.getExecutor().getActiveCount();
    }

    public int getPassiveThreads() {
        return server.getExecutor().getPoolSize() - server.getExecutor().getActiveCount();
    }

    public int getTotalThreads() {
        return server.getExecutor().getPoolSize();
    }

}
