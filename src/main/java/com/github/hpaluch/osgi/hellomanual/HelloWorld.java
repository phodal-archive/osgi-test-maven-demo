package com.github.hpaluch.osgi.hellomanual;

import com.github.hpaluch.osgi.hellomanual.service.HelloService;
import com.github.hpaluch.osgi.hellomanual.service.impl.HelloServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class HelloWorld implements BundleActivator {
    ServiceRegistration helloServiceRegistration;


    public void start(BundleContext context) throws Exception {
        System.out.println("Hello started: " + context.getBundle().getLocation());

        HelloService helloService = new HelloServiceImpl();
        helloServiceRegistration = context.registerService(HelloService.class.getName(), helloService, null);

        System.out.println(helloService.sayHello());
    }

    public void stop(BundleContext context) throws Exception {
        helloServiceRegistration.unregister();
        System.out.println("Hello stopped: " + context.getBundle().getLocation());
    }
}
