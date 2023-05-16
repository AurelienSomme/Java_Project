package View.Task;

import Controller.ApplicationController;
import Model.LeastSoldItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TaskLeastSoldItemsPanel extends JPanel {
    private ArrayList<LeastSoldItem> leastSoldItems;
    private ApplicationController controller;
    private JPanel head, main;
    private JLabel codeLabel, nameLabel, priceLabel, nbSalesLabel, isInPromoLabel;
    private Container container;

    public TaskLeastSoldItemsPanel(ApplicationController controller, ArrayList<LeastSoldItem> leastSoldItems, Container container){
        this.controller = controller;
        this.leastSoldItems = leastSoldItems;
        this.container = container;
        codeLabel = new JLabel("Code");
        nameLabel = new JLabel("Name");
        priceLabel = new JLabel("Price");
        nbSalesLabel = new JLabel("Nb Sales");
        isInPromoLabel = new JLabel("Is in Promo");

        head = new JPanel();
        head.setLayout(new GridLayout(1, 5));
        head.add(codeLabel);
        head.add(nameLabel);
        head.add(priceLabel);
        head.add(nbSalesLabel);
        head.add(isInPromoLabel);
        head.add(new JLabel(""));
        head.add(new JLabel(""));
        add(head);

        main = new JPanel();
        main.setLayout(new GridLayout(leastSoldItems.size(), 7));

        for(int i = 0; i < leastSoldItems.size(); i++){
            LeastSoldItem leastSoldItem = leastSoldItems.get(i);
            main.add(new JLabel(leastSoldItem.getCode()));
            main.add(new JLabel(leastSoldItem.getName()));
            main.add(new JLabel(leastSoldItem.getPrice().toString()));
            main.add(new JLabel(String.valueOf(leastSoldItem.getNbSales())));
            main.add(new JLabel(Boolean.toString(leastSoldItem.isInPromo())));
            JButton buttonPromos = new JButton("Promos History");
            ButtonGetPromosFrame buttonGetPromosFrame = new ButtonGetPromosFrame(leastSoldItem.getCode(), controller);
            buttonPromos.addActionListener(buttonGetPromosFrame);
            main.add(buttonPromos);
            JButton buttonsUpdatePromo = new JButton("Update Promo");
            ButtonFormUpdatePromo buttonFormUpdatePromo = new ButtonFormUpdatePromo(controller, container, leastSoldItem.getCode());
            buttonsUpdatePromo.addActionListener(buttonFormUpdatePromo);
            main.add(buttonsUpdatePromo);
        }
        add(main);
        setLayout(new GridLayout(2,1));
    }
}
