package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.aspect.WriteLog;

@Service
@WriteLog
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public final String sayHello(String name) {
        return "Hello, " + name + "!";
    }

}