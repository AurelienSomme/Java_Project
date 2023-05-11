package View;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.*;

public class UpdateItemPanel extends JPanel {
    private JPanel panelForm;
    private JLabel instruction, code;
    private JTextField codeText;
    private JButton getItemButton;
    private ApplicationController controller;


    public UpdateItemPanel(ApplicationController controller){
        panelForm = new JPanel();
        this.controller = controller;
        panelForm.setLayout(new GridLayout(1, 2));
        instruction = new JLabel("Write code of item");
        code = new JLabel("Code");
        codeText = new JTextField();
        getItemButton = new JButton("Get Item");
        setLayout(new GridLayout(3, 1));
        panelForm.add(code);
        panelForm.add(codeText);
        add(instruction);
        add(panelForm);
        add(getItemButton);

        ButtonGetItem buttonGetItem = new ButtonGetItem(this, controller, codeText);
        getItemButton.addActionListener(buttonGetItem);


    }
}
