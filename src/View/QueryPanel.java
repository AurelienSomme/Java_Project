package View;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.*;

public class QueryPanel extends JPanel {
    private JPanel panel1, panel2, panel3;
    private JPanel queryPanel1, queryPanel2, queryPanel3;

    private JButton buttonQuery1, buttonQuery2, buttonQuery3;
    private ApplicationController controller;

    //Query 1 Form
    private JLabel nameBrand;
    private JComboBox<Integer> refBrandComboBox;

    //Query 2 Form
    private JLabel nameAffair;
    private JComboBox<Integer> refAffairComboBox;

    //Query 3 Form
    private JLabel date;
    private JSpinner dateSpinner;

    public QueryPanel(ApplicationController controller){
        this.controller = controller;

        buttonQuery1 = new JButton("Query 1");
        buttonQuery2 = new JButton("Query 2");
        buttonQuery3 = new JButton("Query 3");

        panel1 = new JPanel();
        queryPanel1 = new JPanel();
        queryPanel1.setLayout(new GridLayout(1, 2));
        nameBrand = new JLabel("Brand Name");
        queryPanel1.add(nameBrand);
        //controller.getIdsBrands
        refBrandComboBox = new JComboBox<>();
        queryPanel1.add(refBrandComboBox);

        panel1.add(queryPanel1);
        panel1.add(buttonQuery1);
        panel1.setLayout(new GridLayout(2,1));
        add(panel1);





        panel2 = new JPanel();
        queryPanel2 = new JPanel();
        queryPanel2.setLayout(new GridLayout(1, 2));
        nameAffair = new JLabel("Affair Name");
        queryPanel2.add(nameAffair);
        //controller.getIdsAffairs
        refAffairComboBox = new JComboBox<>();
        queryPanel2.add(refAffairComboBox);

        panel2.add(queryPanel2);
        panel2.add(buttonQuery2);
        panel2.setLayout(new GridLayout(2,1));
        add(panel2);





        panel3 = new JPanel();
        queryPanel3 = new JPanel();
        queryPanel3.setLayout(new GridLayout(1, 2));
        date = new JLabel("Date");
        queryPanel3.add(date);
        //controller.getDate
        dateSpinner = new JSpinner();
        queryPanel3.add(dateSpinner);

        panel3.add(queryPanel3);
        panel3.add(buttonQuery3);
        panel3.setLayout(new GridLayout(2,1));
        add(panel3);

    }
}
