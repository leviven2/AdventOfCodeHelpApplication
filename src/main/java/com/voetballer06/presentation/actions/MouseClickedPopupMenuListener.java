package com.voetballer06.presentation.actions;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickedPopupMenuListener extends MouseAdapter {

    private final JList<?> jList;
    private final JPopupMenu popupMenu;

    public MouseClickedPopupMenuListener(JList<?> jList, JPopupMenu popupMenu) {
        this.jList = jList;
        this.popupMenu = popupMenu;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        check(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        check(e);
    }

    public void check(MouseEvent event) {
        if (!event.isPopupTrigger()) return;

        jList.setSelectedIndex(jList.locationToIndex(event.getPoint()));
        popupMenu.show(jList, event.getX(), event.getY());
    }

}
