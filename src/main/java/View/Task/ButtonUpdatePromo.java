package View.Task;

import Controller.ApplicationController;
import Model.AddBigDecimalException;
import Model.DateException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ButtonUpdatePromo implements ActionListener {

    private ApplicationController controller;
    private JTextField percentText;
    private JComboBox<String> endDay, endMonth, endYear;

    private BigDecimal percentRate;
    private LocalDate endDate;
    private String code;
    private Container container;

    public ButtonUpdatePromo(ApplicationController controller, JTextField percentText, JComboBox<String> endDay,
                             JComboBox<String> endMonth, JComboBox<String> endYear, String code, Container container){
        this.controller = controller;
        this.percentText = percentText;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.code = code;
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            setValues();
            boolean isUpdated = controller.updatePromo(percentRate, endDate, code);
            if(isUpdated) {
                JOptionPane.showMessageDialog(null, "The promo has been updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                container.removeAll();
                container.add(new TaskPanel(controller, container));
                container.revalidate();
            }
            else
                JOptionPane.showMessageDialog(null, "The promo has not been updated", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setValues() throws AddBigDecimalException, DateException {
        endDate = LocalDate.of(
                Integer.parseInt((String) endYear.getSelectedItem()),
                Integer.parseInt((String) endMonth.getSelectedItem()),
                Integer.parseInt((String) endDay.getSelectedItem())
        );

        if(percentText.getText().matches("[0-9]{1,}\\.{0,1}[0-9]{0,}"))
            percentRate = new BigDecimal(percentText.getText());
        else
            throw new AddBigDecimalException(percentText.getText(), "Percent Rate");
        LocalDate actualDate = LocalDate.now();
        if (actualDate.isAfter(endDate))
            throw new DateException(endDate, "Date (Gregorian)");
    }
}
