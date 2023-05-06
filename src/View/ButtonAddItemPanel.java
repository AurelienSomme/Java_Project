package View;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAddItemPanel implements ActionListener {

    private JPanel addItemPanel;

    private JPanel main;

    private ApplicationController controller;

    public ButtonAddItemPanel(JPanel main, ApplicationController controller){

        this.main = main;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        main.removeAll();
        addItemPanel = new AddItemPanel(controller);
        main.revalidate();
        main.add(addItemPanel);
    }
}
