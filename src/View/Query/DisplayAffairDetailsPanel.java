package View.Query;

import Controller.ApplicationController;
import Model.AffairDetail;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayAffairDetailsPanel extends JPanel{
    private ApplicationController controller;
    private JTable affairDetailsTab;
    private ArrayList<AffairDetail> affairDetails;
    private Object[][] affairDetailsObjectTab;
    private JPanel head, main;

    private String[] nameColumn = {"Brand Name", "Item Name", "Quantity", "Price"};

    public DisplayAffairDetailsPanel(ApplicationController controller, ArrayList<AffairDetail> affairDetails) {
        this.controller = controller;
        this.affairDetails = affairDetails;

        affairDetailsObjectTab = new Object[affairDetails.size()][nameColumn.length];

        for (int i = 0; i < affairDetails.size(); i++) {
            affairDetailsObjectTab[i][0] = affairDetails.get(i).getBrandName();
            affairDetailsObjectTab[i][1] = affairDetails.get(i).getItemName();
            affairDetailsObjectTab[i][2] = affairDetails.get(i).getQuantity();
            affairDetailsObjectTab[i][3] = affairDetails.get(i).getPrice();
        }

        affairDetailsTab = new JTable(affairDetailsObjectTab, nameColumn);
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
