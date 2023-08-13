package View.Main;

import Controller.ApplicationController;
import View.Query.BrandPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ButtonBrandPanel implements ActionListener {
    private JPanel main;
    private ApplicationController controller;
    private BrandPanel brandPanel;

    public ButtonBrandPanel(JPanel main, ApplicationController controller){
        this.main = main;
        this.controller = controller;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        main.removeAll();
        try {
            brandPanel = new BrandPanel(controller);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        main.revalidate();
        main.add(brandPanel);
    }
}
