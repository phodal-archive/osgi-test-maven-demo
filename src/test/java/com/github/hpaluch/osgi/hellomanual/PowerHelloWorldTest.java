package com.github.hpaluch.osgi.hellomanual;

import com.github.hpaluch.osgi.hellomanual.service.impl.HelloServiceImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import static org.mockito.Mockito.*;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(MockNewClass.class)
public class PowerHelloWorldTest {

    @Test
    public void shouldMockServices() throws Exception {
        Bundle bundle = Mockito.mock(Bundle.class);
        BundleContext context = Mockito.mock(BundleContext.class);
        when(bundle.getLocation()).thenReturn("aaa");
        when(context.getBundle()).thenReturn(bundle);

        PowerHelloWorld helloWorld = new PowerHelloWorld();
        helloWorld.start(context);
    }
}
