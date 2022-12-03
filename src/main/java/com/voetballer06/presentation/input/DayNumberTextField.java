package com.voetballer06.presentation.input;

import com.voetballer06.domain.AOCChallenge;
import com.voetballer06.presentation.actions.AddDayNumberAction;

import javax.swing.*;
import java.util.Set;

public class DayNumberTextField extends JTextField {

    public DayNumberTextField(Set<? extends AOCChallenge<?, ?>> aocChallenges, ListModel<String> listModel, EnteredTextStatus enteredTextStatus) {
        super(20);
        this.setBounds(250, 50, 100, 25);
        this.addActionListener(new AddDayNumberAction(listModel, this, aocChallenges, enteredTextStatus));
    }

}
