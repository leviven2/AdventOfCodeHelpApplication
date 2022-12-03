package com.voetballer06.challenges;

import com.voetballer06.domain.AOCChallenge;

import java.util.List;

public class Day1 extends AOCChallenge<Integer, Integer> {

    @Override
    public void solution(List<Integer> input) {
        int answer = input
                .stream()
                .mapToInt(value -> value)
                .sum();
        answer(answer);
        answer(1);
    }

}