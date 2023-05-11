package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonOptionalText implements ActionListener {

    private JTextField jTextField;
    private JCheckBox checkBox;

    public ButtonOptionalText(JTextField jTextField, JCheckBox checkBox){
        this.jTextField = jTextField;
        this.checkBox = checkBox;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(checkBox.isSelected()){
            jTextField.setEnabled(true);
        }
        else{
            jTextField.setEnabled(false);
            jTextField.setText("");
        }
    }
}
