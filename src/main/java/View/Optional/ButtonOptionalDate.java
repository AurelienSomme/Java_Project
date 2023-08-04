package View.Optional;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonOptionalDate implements ActionListener {

    private JComboBox<String> day, month, year;
    private JCheckBox checkBox;

    public ButtonOptionalDate(JComboBox<String> day, JComboBox<String> month, JComboBox<String>year, JCheckBox checkBox){
        this.day = day;
        this.month = month;
        this.year = year;
        this.checkBox = checkBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkBox.isSelected()){
            day.setEnabled(true);
            month.setEnabled(true);
            year.setEnabled(true);
        }
        else{
            day.setEnabled(false);
            month.setEnabled(false);
            year.setEnabled(false);
            day.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
        }
    }
}