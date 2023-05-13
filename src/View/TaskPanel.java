package View;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JPanel {

    private ApplicationController controller;
    private JLabel nbItemsLabel, nbDaysLabel;
    private JComboBox nbItemsSpinner, nbDaysSpinner;
    private JButton validationButton;
    private JPanel main;

    public TaskPanel(ApplicationController controller){
        this.controller = controller;
        nbItemsLabel = new JLabel("Enter the X lowest selling items");
        String[] nbDays = {"1", "2" ,"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16" ,"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] nbSales = {"1", "2" ,"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        nbItemsSpinner = new JComboBox(nbSales);
        nbDaysLabel = new JLabel("Enter the last X months");
        nbDaysSpinner = new JComboBox(nbDays);
        main = new JPanel();
        main.setLayout(new GridLayout(2,2));
        main.add(nbItemsLabel);
        main.add(nbItemsSpinner);
        main.add(nbDaysLabel);
        main.add(nbDaysSpinner);
        add(main);

        validationButton = new JButton("Ok");
        add(validationButton);

    }
}
