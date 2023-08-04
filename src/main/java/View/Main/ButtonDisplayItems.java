package View.Main;

import Controller.ApplicationController;
import View.Display.DisplayItemsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ButtonDisplayItems implements ActionListener {

    private JPanel main;
    private ApplicationController controller;
    private DisplayItemsPanel displayItemPanel;

    public ButtonDisplayItems(JPanel main, ApplicationController controller){
        this.main = main;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        main.removeAll();
        try {
            displayItemPanel = new DisplayItemsPanel(controller);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        main.revalidate();
        main.add(displayItemPanel);
    }
}
