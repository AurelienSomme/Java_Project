package View;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ButtonDisplayItems implements ActionListener {

    private JPanel main;
    private ApplicationController controller;
    private DisplayItemsPanel deleteItemPanel;

    public ButtonDisplayItems(JPanel main, ApplicationController controller){
        this.main = main;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        main.removeAll();
        try {
            deleteItemPanel = new DisplayItemsPanel(controller);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        main.revalidate();
        main.add(deleteItemPanel);
    }
}
