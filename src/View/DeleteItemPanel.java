package View;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class DeleteItemPanel extends JPanel{
    private JPanel panelForm;
    private JLabel instruction, code;
    private JTextField codeText;
    private JButton deleteButton;
    private ApplicationController controller;

    public DeleteItemPanel(ApplicationController controller) throws SQLException {
        panelForm = new JPanel();
        this.controller = controller;
        panelForm.setLayout(new GridLayout(1, 2));
        instruction = new JLabel("Write code of item to delete");
        code = new JLabel("Code");
        codeText = new JTextField();
        deleteButton = new JButton("Delete");
        setLayout(new GridLayout(3, 1));
        panelForm.add(code);
        panelForm.add(codeText);
        add(instruction);
        add(panelForm);
        add(deleteButton);

        ButtonDeleteItem buttonDeleteItem = new ButtonDeleteItem(codeText, controller);
        deleteButton.addActionListener(buttonDeleteItem);

    }


}
