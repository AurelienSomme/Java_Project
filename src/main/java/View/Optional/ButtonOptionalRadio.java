package View.Optional;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonOptionalRadio implements ActionListener {

    private JCheckBox checkBox;
    private JRadioButton radioYes, radioNo;
    public ButtonOptionalRadio(JRadioButton radioYes, JRadioButton radioNo, JCheckBox checkBox){
        this.checkBox = checkBox;
        this.radioYes = radioYes;
        this.radioNo = radioNo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkBox.isSelected()){
            radioYes.setEnabled(true);
            radioYes.setSelected(true);
            radioNo.setEnabled(true);
            radioNo.setSelected(false);
        }
        else{
            radioYes.setEnabled(false);
            radioNo.setEnabled(false);
            radioYes.setSelected(true);
            radioNo.setSelected(false);
        }
    }
}
