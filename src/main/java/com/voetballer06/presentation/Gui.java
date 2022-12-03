package com.voetballer06.presentation;

import com.voetballer06.domain.AOCChallenge;
import com.voetballer06.presentation.input.DayNumberTextField;
import com.voetballer06.presentation.input.EnterNumberLabel;
import com.voetballer06.presentation.input.EnteredTextStatus;
import com.voetballer06.presentation.list.CurrentDaysList;
import com.voetballer06.presentation.list.CurrentDaysListTitle;
import com.voetballer06.presentation.solve.SolveDaysButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Gui {

    public static List<Integer> addedDaysList = new ArrayList<>();

    public Gui(Set<? extends AOCChallenge<?, ?>> aocChallenges) {
        JFrame guiFrame = new JFrame();
        JPanel panel = new JPanel();
        EnterNumberLabel numberLabel = new EnterNumberLabel();
        EnteredTextStatus enteredTextStatus = new EnteredTextStatus();
        CurrentDaysList currentDaysList = new CurrentDaysList(guiFrame, aocChallenges);
        DayNumberTextField textField = new DayNumberTextField(aocChallenges, currentDaysList.getModel(), enteredTextStatus);
        CurrentDaysListTitle currentDaysListTitle = new CurrentDaysListTitle();
        SolveDaysButton solveDaysButton = new SolveDaysButton(aocChallenges);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);

        guiFrame.add(panel, BorderLayout.CENTER);
        panel.add(textField);
        panel.add(numberLabel);
        panel.add(enteredTextStatus);
        panel.add(currentDaysList);
        panel.add(currentDaysListTitle);
        panel.add(solveDaysButton);

        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setLayout(new GridLayout());
        guiFrame.setTitle("AoC Challenge Runner");
        guiFrame.setSize(450, 600);
        guiFrame.setResizable(false);
        guiFrame.setLocationRelativeTo(null);
        guiFrame.setVisible(true);
    }

}
