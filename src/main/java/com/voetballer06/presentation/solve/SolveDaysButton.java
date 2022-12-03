package com.voetballer06.presentation.solve;

import com.voetballer06.domain.AOCChallenge;
import com.voetballer06.presentation.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class SolveDaysButton extends JButton {

    public SolveDaysButton(Set<? extends AOCChallenge<?, ?>> aocChallenges) {
        super("Solve");
        this.setBounds(175, 450, 75, 25);

        this.addActionListener(event -> {
            aocChallenges
                    .stream()
                    .filter(aocChallenge -> Gui.addedDaysList.contains(aocChallenge.getDay()))
                    .forEach(AOCChallenge::executeSolution);

            Optional<? extends AOCChallenge<?, ?>> aocChallenge = aocChallenges
                    .stream()
                    .sorted(Comparator.comparingInt((AOCChallenge<?, ?> o) -> o.getDay()))
                    .reduce((aocChallenge1, aocChallenge2) -> aocChallenge2);
            if (aocChallenge.isEmpty()) return;

            String lastAnswer = String.valueOf(aocChallenge.get().getAnswersMap().get(aocChallenge.get().getAnswersMap().size()));
            StringSelection selection = new StringSelection(lastAnswer);
            Clipboard computerClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            computerClipboard.setContents(selection, selection);
        });
    }

}
