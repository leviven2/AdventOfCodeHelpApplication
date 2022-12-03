package com.voetballer06.presentation.list;

import com.voetballer06.domain.AOCChallenge;
import com.voetballer06.presentation.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Optional;
import java.util.Set;

public class ChangeItemFromListPopupMenu extends JPopupMenu {

    public ChangeItemFromListPopupMenu(JFrame frame, JList<?> jList, ListModel<?> listModel, Set<? extends AOCChallenge<?, ?>> aocChallenges) {
        JMenuItem remove = new JMenuItem("Remove");
        JMenuItem clipboard = new JMenuItem("Clipboard");

        this.add(remove);
        this.add(clipboard);

        remove.addActionListener(event -> {
            if (!(listModel instanceof DefaultListModel<?> defaultListModel)) return;

            try {
                String dayWithNumber = (String) defaultListModel.getElementAt(jList.getSelectedIndex());
                Integer day = Integer.parseInt(dayWithNumber.replaceAll("Day ", ""));

                Gui.addedDaysList.remove(day);
                defaultListModel.removeElementAt(jList.getSelectedIndex());
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException exception) {
                exception.printStackTrace();
            }
        });

        clipboard.addActionListener(event -> {
            if (!(listModel instanceof DefaultListModel<?> defaultListModel)) return;

            String dayWithNumber = (String) defaultListModel.getElementAt(jList.getSelectedIndex());
            int day = Integer.parseInt(dayWithNumber.replaceAll("Day ", ""));

            Optional<? extends AOCChallenge<?, ?>> optionalAocChallenge = aocChallenges
                    .stream()
                    .filter(aocChallenge -> aocChallenge.getDay() == day)
                    .findFirst();
            if (optionalAocChallenge.isEmpty()) return;

            String input = JOptionPane.showInputDialog(frame, "From what part would you like the answer to go into your clipboard?", "What part?");

            try {
                int part = Integer.parseInt(input);
                AOCChallenge<?, ?> aocChallenge = optionalAocChallenge.get();
                aocChallenge.executeSolution();
                if (!aocChallenge.getAnswersMap().containsKey(part)) return;

                String answer = String.valueOf(aocChallenge.getAnswersMap().get(part));
                StringSelection selection = new StringSelection(answer);
                Clipboard computerClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                computerClipboard.setContents(selection, selection);
            } catch (NumberFormatException ignored) {
            }
        });
    }

}
