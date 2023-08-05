package View.Query;

import Controller.ApplicationController;
import Model.ExpiredBatch;

import javax.management.Query;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;

public class ButtonExpiredBatches implements ActionListener {

    private QueryPanel main;
    private ApplicationController controller;
    private JComboBox<String> dateDay, dateMonth, dateYear;
    private LocalDate date;

    public ButtonExpiredBatches(QueryPanel main, ApplicationController controller, JComboBox<String> dateDay,
                                JComboBox<String> dateMonth, JComboBox<String> dateYear){
        this.main = main;
        this.controller = controller;
        this.dateDay = dateDay;
        this.dateMonth = dateMonth;
        this.dateYear = dateYear;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        date = LocalDate.of(
                Integer.parseInt((String) dateYear.getSelectedItem()),
                Integer.parseInt((String) dateMonth.getSelectedItem()),
                Integer.parseInt((String) dateDay.getSelectedItem())
        );

        Object[][] expiredBatches;
        try {
            expiredBatches = controller.getExpiredBatches(date);

            main.removeAll();
            main.add(new DisplayExpiredBatches(controller, expiredBatches));
            main.revalidate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
