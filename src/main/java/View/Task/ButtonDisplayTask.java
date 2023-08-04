package View.Task;

import Controller.ApplicationController;
import Model.LeastSoldItem;
import View.Query.DisplayExpiredBatches;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ButtonDisplayTask implements ActionListener {

    private int nbDays;
    private int nbItems;
    private JComboBox nbItemsCombobox, nbDaysCombobox;
    private ApplicationController controller;
    private JPanel main;
    private Container container;

    public ButtonDisplayTask(JComboBox nbItemsCombobox, JComboBox nbDaysCombobox, ApplicationController controller, JPanel main, Container container){
        this.controller = controller;
        this.nbItemsCombobox = nbItemsCombobox;
        this.nbDaysCombobox = nbDaysCombobox;
        this.main = main;
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<LeastSoldItem> leastSoldItems;
        nbDays = Integer.parseInt(nbDaysCombobox.getSelectedItem().toString());
        nbItems = Integer.parseInt(nbItemsCombobox.getSelectedItem().toString());

        try {
            leastSoldItems = controller.getLeastSoldItems(nbItems, nbDays);
            main.removeAll();
            main.add(new TaskLeastSoldItemsPanel(controller, leastSoldItems, container));
            main.revalidate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
