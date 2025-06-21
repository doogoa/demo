package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aspect.WriteLog;
import com.example.demo.entity.RoundUpList;
import com.example.demo.service.SolutionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@WriteLog
public class ComputeNumeric {
    
    private SolutionService solutionService;
    @Autowired
    private void setSolutionService(SolutionService solutionService){
        this.solutionService = solutionService;
    }

    @PostMapping(value = "/hello/world")
    public String helloWorld(@RequestBody String a) {
        log.info("2023/08/14 create a new project in github");
        return String.valueOf(solutionService.newSolution(Integer.parseInt(a)));
    }

    @PostMapping(value = "/hello/world/sort")
    public String helloWorld(@RequestBody RoundUpList a) {
        log.info("2023/08/14 create a new project in github");
        solutionService.solution(a);
        return String.valueOf(a);
    }
}
