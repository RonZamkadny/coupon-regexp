package com.ronx.coupon.server;

import java.util.concurrent.ThreadPoolExecutor;

public class CouponServer {
    private ThreadPoolExecutor executor;

    public CouponServer(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }

    public void runServer()	{
        executor.prestartAllCoreThreads();
//        while (true) {
//            try {
//                executor.execute(new Task());
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {}
//        } catch(RejectedExecutionException e) {
//            rejected++;
//        }
    }

}
