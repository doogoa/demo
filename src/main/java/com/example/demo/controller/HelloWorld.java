package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloWorldService;
import com.example.demo.util.CommonUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloWorld {
    private static int counter = 0;
    
    private HelloWorldService helloWorldService;
    @Autowired
    private void setSolutionService(HelloWorldService helloWorldService){
        this.helloWorldService = helloWorldService;
    }
    @RequestMapping("/hello/world")
    // 使用 synchronized 保证线程安全
    public synchronized String helloWorld() {
        counter++;
        List<String> finalList = new ArrayList<>(List.of("Hello"));
        List<String> tempList = new ArrayList<>(List.of("World"));

        return CommonUtil.addAll(finalList, tempList).toString() + " " + counter;
    }

    @PostMapping(value = "/hello/world/name")
    public String helloWorldName(@RequestBody String name) {
        log.info("2023/08/14 create a new project in github");
        return helloWorldService.sayHello(name);
    }

}
