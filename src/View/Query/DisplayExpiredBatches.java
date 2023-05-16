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
    private ArrayList<ExpiredBatch> expiredBatches;
    private Object[][] expiredBatchesObjectTab;
    private JPanel head, main;

    private String[] nameColumn = {"Name Item", "Code", "Quantity", "Date", "Delivery Date", "Name Actor"};

    public DisplayExpiredBatches(ApplicationController controller, ArrayList<ExpiredBatch> expiredBatches){
        this.controller = controller;
        this.expiredBatches = expiredBatches;

        expiredBatchesObjectTab = new Object[expiredBatches.size()][nameColumn.length];

        for(int i = 0; i < expiredBatches.size(); i++) {
            expiredBatchesObjectTab[i][0] = expiredBatches.get(i).getItemName();
            expiredBatchesObjectTab[i][1] = expiredBatches.get(i).getCode();
            expiredBatchesObjectTab[i][2] = expiredBatches.get(i).getQuantity();
            expiredBatchesObjectTab[i][3] = expiredBatches.get(i).getDate().getTime().toString();
            expiredBatchesObjectTab[i][4] = expiredBatches.get(i).getDeliveryDate().getTime().toString();
            expiredBatchesObjectTab[i][5] = expiredBatches.get(i).getActorName();
        }

        expiredBatchesTab = new JTable(expiredBatchesObjectTab, nameColumn);
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
