package View.Main;

import Controller.ApplicationController;
import View.Main.MainJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ButtonDBConnection implements ActionListener {

    private Boolean isConnected;

    private JPasswordField passwordField;
    private String password;

    private MainJFrame mainJFrame;
    private ApplicationController controller;

    public ButtonDBConnection(JPasswordField passwordField, MainJFrame mainJFrame, ApplicationController controller){
        this.passwordField = passwordField;
        this.mainJFrame = mainJFrame;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        password = new String(passwordField.getPassword());
        try {
            isConnected = controller.tryConnectionDB(password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        passwordField.setText("");
        if(!isConnected){
            JOptionPane.showMessageDialog(null,
                    "Wrong password",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else{
            try {
                mainJFrame.setElementFrame();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
