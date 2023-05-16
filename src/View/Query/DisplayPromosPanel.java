package View.Query;

import Controller.ApplicationController;
import Model.PromoItemBrand;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayPromosPanel extends JPanel {
    private ApplicationController controller;
    private JTable promosItemsBrandTab;
    private ArrayList<PromoItemBrand> promosItemsBrand;
    private Object[][] promosItemsBrandObjectTab;
    private JPanel head, main;

    private String[] nameColumn = {"Name", "Catalog Price", "Percent Rate", "Start Date", "End Date"};

    public DisplayPromosPanel(ApplicationController controller, ArrayList<PromoItemBrand> promosItemsBrand){
        this.controller = controller;
        this.promosItemsBrand = promosItemsBrand;

        promosItemsBrandObjectTab = new Object[promosItemsBrand.size()][nameColumn.length];

        for(int i = 0; i < promosItemsBrand.size(); i++) {
            promosItemsBrandObjectTab[i][0] = promosItemsBrand.get(i).getName();
            promosItemsBrandObjectTab[i][1] = promosItemsBrand.get(i).getCatalogPrice();
            promosItemsBrandObjectTab[i][2] = promosItemsBrand.get(i).getPercent_rate();
            promosItemsBrandObjectTab[i][3] = promosItemsBrand.get(i).getStart_date().getTime().toString();
            promosItemsBrandObjectTab[i][4] = promosItemsBrand.get(i).getEnd_date().getTime().toString();
        }

        promosItemsBrandTab = new JTable(promosItemsBrandObjectTab, nameColumn);
        promosItemsBrandTab.getColumnModel().getColumn(0).setPreferredWidth(130);
        promosItemsBrandTab.getColumnModel().getColumn(1).setPreferredWidth(130);
        promosItemsBrandTab.getColumnModel().getColumn(2).setPreferredWidth(130);
        promosItemsBrandTab.getColumnModel().getColumn(3).setPreferredWidth(130);
        promosItemsBrandTab.getColumnModel().getColumn(4).setPreferredWidth(130);

        setLayout(new BorderLayout());
        head = new JPanel();
        main = new JPanel();


        head.add(promosItemsBrandTab.getTableHeader());
        main.add(promosItemsBrandTab);
        add(head, BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);

    }
}
