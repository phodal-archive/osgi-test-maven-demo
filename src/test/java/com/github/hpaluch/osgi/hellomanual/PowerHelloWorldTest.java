package com.github.hpaluch.osgi.hellomanual;

import com.github.hpaluch.osgi.hellomanual.service.HelloService;
import com.github.hpaluch.osgi.hellomanual.service.impl.HelloServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PowerHelloWorld.class)
public class PowerHelloWorldTest {
    @Test
    public void shouldMockServices() throws Exception {
        Bundle bundle = Mockito.mock(Bundle.class);
        BundleContext context = Mockito.mock(BundleContext.class);
        when(bundle.getLocation()).thenReturn("aaa");
        when(context.getBundle()).thenReturn(bundle);

        HelloServiceImpl mockServiceImpl = mock(HelloServiceImpl.class);
        PowerMockito.whenNew(HelloServiceImpl.class).withNoArguments().thenReturn(mockServiceImpl);

        PowerHelloWorld helloWorld = new PowerHelloWorld();
        helloWorld.start(context);

        verify(mockServiceImpl, times(1)).sayHello();
    }
}
