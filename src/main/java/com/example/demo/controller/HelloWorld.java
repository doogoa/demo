package com.example.demo.controller;

import com.example.demo.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class HelloWorld {
    @RequestMapping("/hello/world")
    public String helloWorld() {
        log.info("2023/04/14 create a new project in github");
        List<String> finalList = new ArrayList<>(List.of("Hello"));
        List<String> tempList = new ArrayList<>(List.of("World"));

        return CommonUtil.addAll(finalList, tempList).toString();
    }

}
