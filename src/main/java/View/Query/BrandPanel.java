package View.Query;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class BrandPanel extends JPanel {
    private JPanel main;
    private ApplicationController controller;
    private Object[][] brandsObjectTab;
    private JTable brandsTab;
    private JPanel head;
    private String[] nameColumnBrand = {"Id", "Nom", "CEO", "Date de creation", "Description"};

    public BrandPanel(ApplicationController controller) throws SQLException {
        this.controller = controller;
        brandsObjectTab = controller.getAllBrands();

        brandsTab = new JTable(brandsObjectTab, nameColumnBrand);

        head = new JPanel();
        main = new JPanel();

        setLayout(new BorderLayout());


        brandsTab.getColumnModel().getColumn(0).setPreferredWidth(130);
        brandsTab.getColumnModel().getColumn(1).setPreferredWidth(130);
        brandsTab.getColumnModel().getColumn(2).setPreferredWidth(130);
        brandsTab.getColumnModel().getColumn(3).setPreferredWidth(130);
        brandsTab.getColumnModel().getColumn(4).setPreferredWidth(330);

        head.add(brandsTab.getTableHeader());
        main.add(brandsTab);
        add(head, BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);


    }


}
