package View;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ButtonDeleteItemPanel implements ActionListener {
    private JPanel deleteItemPanel;
    private ApplicationController controller;
    private JPanel main;

    public ButtonDeleteItemPanel(JPanel main, ApplicationController controller){

        this.main = main;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        main.removeAll();
        try {
            deleteItemPanel = new DeleteItemPanel(controller);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        main.revalidate();
        main.add(deleteItemPanel);
    }
}
