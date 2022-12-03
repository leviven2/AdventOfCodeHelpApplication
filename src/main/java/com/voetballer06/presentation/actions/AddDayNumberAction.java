package com.voetballer06.presentation.actions;

import com.voetballer06.domain.AOCChallenge;
import com.voetballer06.presentation.input.EnteredTextStatus;
import com.voetballer06.presentation.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Set;

public class AddDayNumberAction extends AbstractAction {

    private final JTextField textField;
    private final EnteredTextStatus enteredTextStatus;
    private final Set<? extends AOCChallenge<?, ?>> aocChallenges;
    private final ListModel<String> listModel;


    public AddDayNumberAction(ListModel<String> listModel, JTextField textField, Set<? extends AOCChallenge<?, ?>> aocChallenges, EnteredTextStatus enteredTextStatus) {
        this.listModel = listModel;
        this.textField = textField;
        this.aocChallenges = aocChallenges;
        this.enteredTextStatus = enteredTextStatus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int day = Integer.parseInt(e.getActionCommand());
            if (aocChallenges
                    .stream()
                    .map(AOCChallenge::getDay)
                    .noneMatch(aocDay -> aocDay == day)) {
                enteredTextStatus.setText("<html>This day doesn't exist</html>");
                textField.setText("");
                return;
            }

            if (!(listModel instanceof DefaultListModel<String> defaultListModel)) return;
            if (Gui.addedDaysList.contains(day)) {
                enteredTextStatus.setText("<html>You have already added this day.</html>");
                textField.setText("");
                return;
            }

            Gui.addedDaysList.add(day);
            defaultListModel.addElement("Day " + day);
            enteredTextStatus.setText("<html>Day " + day + " was added.</html>");
            textField.setText("");
        } catch (NumberFormatException exception) {
            enteredTextStatus.setText("<html>Input has to be a number!</html>");
            textField.setText("");
        }
    }

}
