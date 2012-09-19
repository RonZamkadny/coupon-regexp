package com.ronx.coupon.service;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.*;

@WebService(
        portName = "CouponWSPortName",
        serviceName = "CouponWS",
        endpointInterface = "com.ronx.coupon.service.CouponService",
        targetNamespace = "http://couponws"
)
public class CouponServiceImpl implements CouponService {

    @Override
    public List<String> list() {
        return null;
    }

    public static void main(String[] args) throws IOException {
//        HttpServer server = null;
        int numConnections = 1000;
        ExecutorService threads = Executors.newFixedThreadPool(numConnections);
//        server = HttpServer.create(new InetSocketAddress(8080), numConnections);
//        server.setExecutor(threads);
//        server.start();
//
//        HttpContext context = server.createContext("/WS/coupon");
//        endpoint.publish(context);

        //ThreadPoolExecutor threads = new ThreadPoolExecutor(10,20, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(QUEUE_CAPACITY));

        Endpoint endpoint = Endpoint.publish("http://localhost:8888/WS/coupon", new CouponServiceImpl());
        endpoint.setExecutor(threads);



    }

}
