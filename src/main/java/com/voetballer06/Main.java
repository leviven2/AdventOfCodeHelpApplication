package com.voetballer06;

import com.voetballer06.domain.AOCChallenge;
import com.voetballer06.presentation.Gui;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.voetballer06.challenges");
        Set<? extends AOCChallenge<?, ?>> aocChallenges = reflections.getSubTypesOf(AOCChallenge.class)
                .stream()
                .map(challengeClass -> {
                    try {
                        Constructor<?> challengeConstructor = challengeClass.getConstructor();
                        return (AOCChallenge<?, ?>) challengeConstructor.newInstance();
                    } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                             IllegalAccessException exception) {
                        throw new RuntimeException(exception);
                    }
                })
                .collect(Collectors.toSet());

        new Gui(aocChallenges);
    }

}