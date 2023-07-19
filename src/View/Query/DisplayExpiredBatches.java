package View.Query;

import Controller.ApplicationController;
import Model.ExpiredBatch;
import Model.PromoItemBrand;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayExpiredBatches extends JPanel {

    private ApplicationController controller;
    private JTable expiredBatchesTab;
    private Object[][] expiredBatches;
    private JPanel head, main;

    private String[] nameColumn = {"Name Item", "Code", "Quantity", "Date", "Delivery Date", "Name Actor"};

    public DisplayExpiredBatches(ApplicationController controller, Object[][] expiredBatches){
        this.controller = controller;
        this.expiredBatches = expiredBatches;



        expiredBatchesTab = new JTable(expiredBatches, nameColumn);
        expiredBatchesTab.getColumnModel().getColumn(0).setPreferredWidth(130);
        expiredBatchesTab.getColumnModel().getColumn(1).setPreferredWidth(130);
        expiredBatchesTab.getColumnModel().getColumn(2).setPreferredWidth(130);
        expiredBatchesTab.getColumnModel().getColumn(3).setPreferredWidth(130);
        expiredBatchesTab.getColumnModel().getColumn(4).setPreferredWidth(130);
        expiredBatchesTab.getColumnModel().getColumn(4).setPreferredWidth(130);

        setLayout(new BorderLayout());
        head = new JPanel();
        main = new JPanel();


        head.add(expiredBatchesTab.getTableHeader());
        main.add(expiredBatchesTab);
        add(head, BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);


    }

}
