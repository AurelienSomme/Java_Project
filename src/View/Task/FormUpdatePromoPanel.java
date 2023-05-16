package View.Task;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.*;

public class FormUpdatePromoPanel extends JPanel {

    private JPanel main, datePanel;
    private ApplicationController controller;
    private JLabel percentLabel, endDateLabel;
    private JTextField percentText;
    private JComboBox<String> endDay, endMonth, endYear;
    private JButton buttonUpdate;
    private String code;
    private Container container;

    public FormUpdatePromoPanel(ApplicationController controller, String code, Container container){
        this.controller = controller;
        this.container = container;
        String[] days = {"1", "2" ,"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" ,"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] years = {"2023", "2024", "2025"};
        this.code = code;
        main = new JPanel();
        datePanel = new JPanel();
        endDay = new JComboBox<>(days);
        endMonth =  new JComboBox<>(months);
        endYear = new JComboBox<>(years);
        datePanel.add(endDay);
        datePanel.add(endMonth);
        datePanel.add(endYear);

        main.setLayout(new GridLayout(2, 2));

        percentLabel = new JLabel("Percent Rate");
        percentText = new JTextField();

        endDateLabel = new JLabel("End Date");

        main.add(percentLabel);
        main.add(percentText);
        main.add(endDateLabel);
        main.add(datePanel);

        buttonUpdate = new JButton("Update");
        ButtonUpdatePromo buttonUpdatePromo = new ButtonUpdatePromo(controller, percentText, endDay, endMonth, endYear, code, container);
        buttonUpdate.addActionListener(buttonUpdatePromo);

        add(main);
        add(buttonUpdate);
    }
}
