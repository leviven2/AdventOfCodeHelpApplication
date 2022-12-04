package com.voetballer06.challenges;

import com.voetballer06.domain.AOCChallenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day4 extends AOCChallenge<String, Integer> {

    @Override
    public void solution(List<String> input) {
        int totalFullyContains = 0;
        int totalOverlaps = 0;

        for (String pair : input) {

            String firstElf = pair.substring(0, pair.indexOf(','));
            String secondElf = pair.substring(pair.indexOf(',') + 1);
            List<Integer> firstElfFloorsToClean = getFloorsToCleanFromElfRange(firstElf);
            List<Integer> secondElfFloorsToClean = getFloorsToCleanFromElfRange(secondElf);

            if (overlap(firstElfFloorsToClean, secondElfFloorsToClean)) totalOverlaps++;
            if (fullyContains(firstElfFloorsToClean, secondElfFloorsToClean)) totalFullyContains++;
        }

        answer(totalFullyContains);
        answer(totalOverlaps);
    }

    private List<Integer> getFloorsToCleanFromElfRange(String range) {
        int firstFloor = Integer.parseInt(range.substring(0, range.indexOf('-')));
        int lastFloor = Integer.parseInt(range.substring(range.indexOf('-') + 1));

        List<Integer> floors = new ArrayList<>();
        for (int floor = firstFloor; floor < lastFloor + 1; floor++) {
            floors.add(floor);
        }

        return floors;
    }

    private boolean fullyContains(List<Integer> firstElf, List<Integer> secondElf) {
        if (new HashSet<>(firstElf).containsAll(secondElf)) return true;

        return new HashSet<>(secondElf).containsAll(firstElf);
    }

    private boolean overlap(List<Integer> firstElf, List<Integer> secondElf) {
        if (firstElf
                .stream()
                .anyMatch(secondElf::contains)) return true;

        return secondElf
                .stream()
                .anyMatch(firstElf::contains);
    }

}
