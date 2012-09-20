package com.ronx.coupon.server;

public interface ServerControllerMBean  {
        public int getCorePoolSize();
        public void setCorePoolSize(int corePoolSize);
        public int getMaxPoolSize();
        public void setMaxPoolSize(int maxPoolSize);
        public int getActiveThreads();
        public int getPassiveThreads();
        public int getTotalThreads();
}
