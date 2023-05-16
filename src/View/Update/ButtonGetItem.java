package View.Update;

import Controller.ApplicationController;
import Model.AddCodeException;
import Model.Item;
import View.Update.FormUpdatePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonGetItem implements ActionListener {
    private JPanel main;
    private ApplicationController controller;
    private JTextField codeText;
    private String code;
    private Item item;
    private FormUpdatePanel formUpdatePanel;

    public ButtonGetItem(JPanel main, ApplicationController controller, JTextField codeText){
        this.main = main;
        this.controller = controller;
        this.codeText = codeText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            setCode();
            item = controller.getItem(code);
            if(item == null){
                JOptionPane.showMessageDialog(null, "Item not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                setUpdatePanel(item);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setUpdatePanel(Item item){
        main.removeAll();

        formUpdatePanel = new FormUpdatePanel(item, controller, main);
        main.add(formUpdatePanel);

        main.revalidate();
    }


    public void setCode() throws AddCodeException {
        if(!codeText.getText().isBlank())
            code = codeText.getText();
        else
            throw new AddCodeException(codeText.getText());
    }
}
