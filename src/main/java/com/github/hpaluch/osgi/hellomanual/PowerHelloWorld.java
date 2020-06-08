package com.github.hpaluch.osgi.hellomanual;

import com.github.hpaluch.osgi.hellomanual.service.HelloService;
import com.github.hpaluch.osgi.hellomanual.service.impl.HelloServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class PowerHelloWorld implements BundleActivator {
    ServiceRegistration helloServiceRegistration;


    public void start(BundleContext context) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        helloServiceRegistration = context.registerService(HelloService.class.getName(), helloService, null);
    }

    public void stop(BundleContext context) throws Exception {
        helloServiceRegistration.unregister();
    }
}
