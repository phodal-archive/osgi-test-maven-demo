package com.github.hpaluch.osgi.hellomanual;

import com.github.hpaluch.osgi.hellomanual.service.HelloService;
import com.github.hpaluch.osgi.hellomanual.service.impl.HelloServiceImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import static org.mockito.Mockito.*;

public class HelloWorldTest {
    @Test
    public void shouldVerifyGetLocationWhenStart() throws Exception {
        Bundle bundle = Mockito.mock(Bundle.class);
        BundleContext context = Mockito.mock(BundleContext.class);

        when(bundle.getLocation()).thenReturn("aaa");
        when(context.getBundle()).thenReturn(bundle);

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.start(context);

        verify(bundle, times(1)).getLocation();
    }

    @Test
    public void shouldMockServices() throws Exception {
        HelloServiceImpl service = Mockito.mock(HelloServiceImpl.class);
        Bundle bundle = Mockito.mock(Bundle.class);
        BundleContext context = Mockito.mock(BundleContext.class);
        when(bundle.getLocation()).thenReturn("aaa");
        when(context.getBundle()).thenReturn(bundle);

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.start(context);

        verify(service, times(1)).sayHello();
    }
}
