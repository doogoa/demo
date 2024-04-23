package com.example.demo.controller;

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
public class HelloWorld {
    private SolutionService solutionService;
    @Autowired
    private void setSolutionService(SolutionService solutionService){
        this.solutionService = solutionService;
    }
    @RequestMapping("/hello/world")
    public String helloWorld() {
        log.info("2023/04/14 create a new project in github");
        List<String> finalList = new ArrayList<>(List.of("Hello"));
        List<String> tempList = new ArrayList<>(List.of("World"));

        return CommonUtil.addAll(finalList, tempList).toString();
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
