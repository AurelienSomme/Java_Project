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
    private ArrayList<Item> items;
    private Object[][] itemsObjectTab;
    private JPanel head, main;

    private String[] nameColumn = {"Code", "Ref brand", "Name", "Catalog price", "Packaging", "VAT","Stock quantity", "Threshold", "Automatic order", "On-sale date", "Reduction points", "Production date"};

    public DisplayItemsPanel(ApplicationController controller) throws SQLException {


        this.controller = controller;

        items = controller.getAllItems();



        itemsObjectTab = new Object[items.size()][nameColumn.length];

        for(int i = 0; i < items.size(); i++){

            itemsObjectTab[i][0] = items.get(i).getCode();
            itemsObjectTab[i][1] = items.get(i).getRefBrand();
            itemsObjectTab[i][2] = items.get(i).getName();
            itemsObjectTab[i][3] = items.get(i).getCatalogPrice();
            itemsObjectTab[i][4] = items.get(i).getPackaging();
            itemsObjectTab[i][5] = items.get(i).getVAT();
            itemsObjectTab[i][6] = items.get(i).getStockQuantity();
            itemsObjectTab[i][7] = items.get(i).getThresholdLimit();
            itemsObjectTab[i][8] = items.get(i).getAutomaticOrder();
            itemsObjectTab[i][9] = items.get(i).getSaleDate().getTime().toGMTString();;
            if(items.get(i).getReductionPoints() != null)
                itemsObjectTab[i][10] = items.get(i).getReductionPoints();
            if(items.get(i).getProductionDate() != null)
                itemsObjectTab[i][11] = items.get(i).getProductionDate().getTime().toGMTString();
        }

        itemsTab = new JTable(itemsObjectTab, nameColumn);

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
