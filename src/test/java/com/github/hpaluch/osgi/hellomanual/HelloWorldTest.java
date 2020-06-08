package com.github.hpaluch.osgi.hellomanual;

import org.junit.Test;
import org.mockito.Mockito;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import java.util.Dictionary;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class HelloWorldTest {
    @Test
    public void shouldVerifyGetLocationWhenStart() throws Exception {
        Bundle bundle = Mockito.mock(Bundle.class);
        BundleContext context = Mockito.mock(BundleContext.class);
        Dictionary<String, String> dict = new Hashtable<>();
        when(bundle.getHeaders()).thenReturn(dict);
        when(bundle.getLocation()).thenReturn("aaa");
        when(context.getBundle()).thenReturn(bundle);

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.start(context);

        verify(bundle, times(1)).getLocation();

        assertEquals(bundle.getHeaders().get("example"), "hello");
    }
}
