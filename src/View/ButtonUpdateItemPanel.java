package View;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonUpdateItemPanel implements ActionListener {
    private JPanel updateItemPanel;

    private JPanel main;

    private ApplicationController controller;

    public ButtonUpdateItemPanel(JPanel main, ApplicationController controller){

        this.main = main;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        main.removeAll();
        updateItemPanel = new UpdateItemPanel(controller);
        main.revalidate();
        main.add(updateItemPanel);
    }
}
