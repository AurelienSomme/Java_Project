package View.Main;





import Controller.ApplicationController;

import javax.swing.*;


public class PasswordPanel extends JPanel {
    private MainJFrame mainJFrame;
    private ApplicationController controller;
    public PasswordPanel(MainJFrame mainJFrame, ApplicationController controller) {
        JLabel passwordLabel = new JLabel("Password:");
        this.controller = controller;
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');
        this.mainJFrame = mainJFrame;

        JButton button = new JButton("Enter");

        ButtonDBConnection buttonDBConnection = new ButtonDBConnection(passwordField, mainJFrame, controller);
        button.addActionListener(buttonDBConnection);

        this.add(passwordLabel);
        this.add(passwordField);
        this.add(button);
    }
}