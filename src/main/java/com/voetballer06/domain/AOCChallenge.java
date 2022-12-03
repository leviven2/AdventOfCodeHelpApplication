package com.voetballer06.domain;

import com.voetballer06.domain.converter.StringConverter;
import com.voetballer06.domain.converter.StringConverterFactory;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AOCChallenge<I, A> {

    private final int day;
    private final List<I> input;
    private final HashMap<Integer, A> answersMap = new HashMap<>();
    private int part = 1;

    public AOCChallenge() {
        day = getDayFromClass();
        if (day == -1) {
            input = null;
            return;
        }

        File file = new File("src/main/resources/day" + day + ".txt");
        if (!file.exists()) {
            input = new ArrayList<>();
            return;
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException exception) {
            input = new ArrayList<>();
            return;
        }

        input = new ArrayList<>();
        try {
            String line;
            Class<I> type = (Class<I>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            StringConverter<I> stringConverterFromType = new StringConverterFactory().createStringConverterFromType(type);
            while ((line = reader.readLine()) != null) {
                I convertedFromString = stringConverterFromType.convertFromString(line);
                if (convertedFromString == null) continue;

                input.add(convertedFromString);
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public abstract void solution(List<I> input);

    public void executeSolution() {
        part = 1;
        solution(input);
    }

    public void answer(A answer) {
        this.answersMap.put(part, answer);
        System.out.println("Day " + day + ", part " + part + ": " + answer);
        part++;
    }

    public int getDay() {
        return this.day;
    }

    public HashMap<Integer, A> getAnswersMap() {
        return answersMap;
    }

    private int getDayFromClass() {
        try {
            String dayNumber = this.getClass().getSimpleName().replaceAll("Day", "");
            return Integer.parseInt(dayNumber);
        } catch (NumberFormatException exception) {
            return -1;
        }
    }

}