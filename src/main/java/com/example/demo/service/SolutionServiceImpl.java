package com.example.demo.service;

import com.example.demo.entity.RoundUpList;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class SolutionServiceImpl implements SolutionService {
    @Override
    public int newSolution(int n) {
        return switch (n) {
            case 0 -> 0;
            case 1, 2 -> 1;
            case 3 -> 2;
            default -> newSolution(n - 3) + newSolution(n - 1);
        };
        
    }

    @Override
    public void solution(RoundUpList roundUpList) {
        roundUpList.getListNumber().sort((h1, h2) -> {
            int diff1 = Math.abs(h1 - roundUpList.getRoundUp());
            int diff2 = Math.abs(h2 - roundUpList.getRoundUp());
            return diff1 == diff2 ? h1 - h2 : diff1 - diff2;
        });

        IntStream.range(0, roundUpList.getListNumber().size()).forEach(i -> {
            System.out.print(roundUpList.getListNumber().get(i));
            if (i != roundUpList.getListNumber().size() - 1) {
                System.out.print(" ");
            }
        });
    }
}