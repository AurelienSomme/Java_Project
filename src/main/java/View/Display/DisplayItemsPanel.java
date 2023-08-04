package View.Display;

import Controller.ApplicationController;
import Model.Item;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisplayItemsPanel extends JPanel {
    private ApplicationController controller;
    private JTable itemsTab;
    private Object[][] items;
    private JPanel head, main;

    private String[] nameColumn = {"Code", "Ref brand", "Name", "Catalog price", "Packaging", "VAT","Stock quantity", "Threshold", "Automatic order", "On-sale date", "Reduction points", "Production date"};

    public DisplayItemsPanel(ApplicationController controller) throws SQLException {


        this.controller = controller;

        items = controller.getAllItems();



        itemsTab = new JTable(items, nameColumn);

        itemsTab.getColumnModel().getColumn(6).setPreferredWidth(85);
        itemsTab.getColumnModel().getColumn(3).setPreferredWidth(85);
        itemsTab.getColumnModel().getColumn(9).setPreferredWidth(130);
        itemsTab.getColumnModel().getColumn(11).setPreferredWidth(130);


        setLayout(new BorderLayout());
        head = new JPanel();
        main = new JPanel();


        head.add(itemsTab.getTableHeader());
        main.add(itemsTab);
        add(head, BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);


    }




}
