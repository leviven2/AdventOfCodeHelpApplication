package com.voetballer06.presentation.list;

import com.voetballer06.domain.AOCChallenge;
import com.voetballer06.presentation.actions.MouseClickedPopupMenuListener;

import javax.swing.*;
import java.util.Set;

public class CurrentDaysList extends JList<String> {

    public CurrentDaysList(JFrame frame, Set<? extends AOCChallenge<?, ?>> aocChallenges) {
        super(new CurrentDaysListModel());
        this.setBounds(50, 125, 300, 300);
        ChangeItemFromListPopupMenu popupMenu = new ChangeItemFromListPopupMenu(frame, this, this.getModel(), aocChallenges);
        this.addMouseListener(new MouseClickedPopupMenuListener(this, popupMenu));
    }

}
