package com.github.hpaluch.osgi.hellomanual.service.impl;

import com.github.hpaluch.osgi.hellomanual.service.HelloService;

public class HelloServiceImpl implements HelloService {
    public String sayHello() {
        System.out.println("Inside HelloServiceImple.sayHello()");
        return "Say Hello";
    }
}
