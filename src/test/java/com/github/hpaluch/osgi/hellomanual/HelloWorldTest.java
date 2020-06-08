package com.github.hpaluch.osgi.hellomanual;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import static org.mockito.Mockito.when;

public class HelloWorldTest {
    @Test
    public void start() throws Exception {
        Bundle bundle = Mockito.mock(Bundle.class);
        BundleContext context = Mockito.mock(BundleContext.class);

        when(bundle.getLocation()).thenReturn("aaa");
        when(context.getBundle()).thenReturn(bundle);

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.start(context);
    }
}
