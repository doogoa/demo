package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.aspect.WriteLog;

import lombok.extern.slf4j.Slf4j;

@Service
@WriteLog
@Slf4j
public class HelloWorldServiceImpl implements HelloWorldService {

    /*
     * 这是一个实现了HelloWorldService接口的方法,JDK的类代理能够代理到此方法,即便此方法用了final修饰
     * 因为JDK的类代理是基于接口的代理,只要方法在接口中定义了,就可以被代理
     * 但是如果方法被final修饰,则无法被子类重写,因此在CGLIB的类代理中,此方法不会被拦截
     * 但是在JDK的类代理中,此方法仍然可以被拦截
     * 这意味着如果你使用JDK代理, sayHello方法会被拦截并记录日志
     * 如果你使用CGLIB代理, sayHello方法不会被拦截
     * 因为CGLIB是基于类的代理,而JDK是基于接口的代理
     */

    @Override
    public final String sayHello(String name) {
        log.info("Executing sayHello with name: {}", name);
        String defaulString = getDefaultString();
        log.info("Default greeting: {}", defaulString);
        return "Hello, " + name + "!";
    }

    /*
     * 这不是重写的接口方法, JDK的类代理无法代理到此方法
     * 但是CGLIB的类代理可以代理到此方法
     * 因为CGLIB是基于类的代理，而JDK是基于接口的代理
     * 这意味着如果你使用CGLIB代理，getDefaultString方法会被拦截并记录日志
     * 如果你使用JDK代理，getDefaultString方法不会被拦截
     */

    public String getDefaultString() {
        return "Hello, World!";
    }

}