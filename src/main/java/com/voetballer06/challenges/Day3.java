package com.voetballer06.challenges;

import com.voetballer06.domain.AOCChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day3 extends AOCChallenge<String, Integer> {

    @Override
    public void solution(List<String> input) {
        int totalPriority = 0;
        int totalPriorityPart2 = 0;
        List<String> currentGroup = new ArrayList<>();

        for (String rucksack : input) {

            String firstCompartment = rucksack.substring(0, rucksack.length() / 2);
            String secondCompartment = rucksack.substring(rucksack.length() / 2);
            for (int index = 0; index < firstCompartment.length(); index++) {
                char firstChar = firstCompartment.charAt(index);
                if (!secondCompartment.contains(String.valueOf(firstChar))) continue;

                char commonChar = firstCompartment.charAt(index);
                int priority = 1;
                if (Character.isUpperCase(commonChar)) {
                    priority += commonChar - 'A';
                    priority += 26;
                } else {
                    priority += commonChar - 'a';
                }

                totalPriority += priority;
                break;
            }

            currentGroup.add(rucksack);
            if (currentGroup.size() < 3) continue;

            HashMap<Integer, List<Character>> rucksacksCharsMap = new HashMap<>();
            for (int rucksackIndex = 0; rucksackIndex < currentGroup.size(); rucksackIndex++) {
                List<Character> currentRucksackCharacters = new ArrayList<>();

                for (int index = 0; index < currentGroup.get(rucksackIndex).length(); index++) {
                    currentRucksackCharacters.add(currentGroup.get(rucksackIndex).charAt(index));
                }

                rucksacksCharsMap.put(rucksackIndex, currentRucksackCharacters);
            }

            List<Character> currentCommonChars = rucksacksCharsMap.get(0);
            for (int index = 1; index < rucksacksCharsMap.size(); index++) {
                List<Character> characters = rucksacksCharsMap.get(index);
                List<Character> commonChars = new ArrayList<>();
                for (int charIndex = 0; charIndex < characters.size(); charIndex++) {
                    if (!currentCommonChars.contains(characters.get(charIndex))) continue;

                    commonChars.add(characters.get(charIndex));
                }

                currentCommonChars.clear();
                currentCommonChars.addAll(commonChars);
            }

            char badgeChar = currentCommonChars.get(0);
            int priority = 1;
            if (Character.isUpperCase(badgeChar)) {
                priority += badgeChar - 'A';
                priority += 26;
            } else {
                priority += badgeChar - 'a';
            }

            totalPriorityPart2 += priority;
            currentGroup.clear();
        }

        answer(totalPriority);
        answer(totalPriorityPart2);
    }

}
