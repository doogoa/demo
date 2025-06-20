package com.example.demo.controller;

import com.example.demo.aspect.WriteLog;
import com.example.demo.entity.RoundUpList;
import com.example.demo.service.SolutionService;
import com.example.demo.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@WriteLog
public class HelloWorld {
    private static int counter = 0;
    
    private SolutionService solutionService;
    @Autowired
    private void setSolutionService(SolutionService solutionService){
        this.solutionService = solutionService;
    }
    @RequestMapping("/hello/world")
    // 使用 synchronized 保证线程安全
    public synchronized String helloWorld() {
        counter++;
        List<String> finalList = new ArrayList<>(List.of("Hello"));
        List<String> tempList = new ArrayList<>(List.of("World"));

        return CommonUtil.addAll(finalList, tempList).toString() + " " + counter;
    }

    @PostMapping(value = "/hello/world")
    public String helloWorld(@RequestBody String a) {
        log.info("2023/08/14 create a new project in github");
        log.info(a);
        return String.valueOf(solutionService.newSolution(Integer.parseInt(a)));
    }

    @PostMapping(value = "/hello/world/sort")
    public String helloWorld(@RequestBody RoundUpList a) {
        log.info("2023/08/14 create a new project in github");
        solutionService.solution(a);
        return String.valueOf(a);
    }
}
