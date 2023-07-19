package View.Query;

import Controller.ApplicationController;
import Model.PromoItemBrand;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayPromosPanel extends JPanel {
    private ApplicationController controller;
    private JTable promosItemsBrandTab;
    private Object[][] promosItemsBrand;
    private JPanel head, main;

    private String[] nameColumn = {"Name", "Catalog Price", "Percent Rate", "Start Date", "End Date"};

    public DisplayPromosPanel(ApplicationController controller, Object[][] promosItemsBrand){
        this.controller = controller;
        this.promosItemsBrand = promosItemsBrand;


        promosItemsBrandTab = new JTable(promosItemsBrand, nameColumn);
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
