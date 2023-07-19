package View.Query;

import Controller.ApplicationController;
import Model.AffairDetail;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayAffairDetailsPanel extends JPanel{
    private ApplicationController controller;
    private JTable affairDetailsTab;
    private Object[][] affairDetails;
    private JPanel head, main;

    private String[] nameColumn = {"Brand Name", "Item Name", "Quantity", "Price"};

    public DisplayAffairDetailsPanel(ApplicationController controller, Object[][] affairDetails) {
        this.controller = controller;
        this.affairDetails = affairDetails;


        affairDetailsTab = new JTable(affairDetails, nameColumn);
        affairDetailsTab.getColumnModel().getColumn(0).setPreferredWidth(130);
        affairDetailsTab.getColumnModel().getColumn(1).setPreferredWidth(130);
        affairDetailsTab.getColumnModel().getColumn(2).setPreferredWidth(130);
        affairDetailsTab.getColumnModel().getColumn(3).setPreferredWidth(130);


        setLayout(new BorderLayout());
        head = new JPanel();
        main = new JPanel();


        head.add(affairDetailsTab.getTableHeader());
        main.add(affairDetailsTab);
        add(head, BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);
    }

}
