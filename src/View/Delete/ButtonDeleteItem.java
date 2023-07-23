package View.Delete;

import Controller.ApplicationController;
import Model.AddCodeException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ButtonDeleteItem implements ActionListener {

    private String code;
    private JTextField codeText;
    private ApplicationController controller;

    public ButtonDeleteItem(JTextField codeText, ApplicationController controller){
        this.codeText = codeText;
        this.controller = controller;
    }


    @Override
    public void actionPerformed(ActionEvent e){
        boolean isDeleted;
        try {
            setCode();
            try {
                isDeleted = controller.deleteItem(code);
                if(isDeleted)
                    JOptionPane.showMessageDialog(null, "The item has been deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "The item has not been deleted (code not in DB or error SQL)", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        codeText.setText("");
    }

    public void setCode() throws AddCodeException {
        if(!codeText.getText().isBlank()) {
            code = codeText.getText();
        }else
            throw new AddCodeException(codeText.getText());
    }
}
