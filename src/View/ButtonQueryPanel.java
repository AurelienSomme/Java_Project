package View;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonQueryPanel implements ActionListener {

    private JPanel main;
    private ApplicationController controller;
    private QueryPanel queryPanel;

    public ButtonQueryPanel(JPanel main, ApplicationController controller){
        this.main = main;
        this.controller = controller;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        main.removeAll();
        queryPanel = new QueryPanel(controller);
        main.revalidate();
        main.add(queryPanel);
    }
}
