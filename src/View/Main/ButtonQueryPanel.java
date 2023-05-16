package View.Main;

import Controller.ApplicationController;
import View.Query.QueryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
        try {
            queryPanel = new QueryPanel(controller);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        main.revalidate();
        main.add(queryPanel);
    }
}
