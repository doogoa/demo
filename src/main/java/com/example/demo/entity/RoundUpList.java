package com.example.demo.entity;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoundUpList {
    private int roundUp;
    private List<Integer> listNumber;

}
