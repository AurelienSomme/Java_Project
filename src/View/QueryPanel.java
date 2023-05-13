package View;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

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
    private JComboBox<String> dateDay, dateMonth, dateYear;
    private JPanel panelDate;

    public QueryPanel(ApplicationController controller) throws SQLException {
        this.controller = controller;

        buttonQuery1 = new JButton("Query 1");
        buttonQuery2 = new JButton("Query 2");
        buttonQuery3 = new JButton("Query 3");

        panel1 = new JPanel();
        queryPanel1 = new JPanel();
        queryPanel1.setLayout(new GridLayout(1, 2));
        nameBrand = new JLabel("Brand Id");
        queryPanel1.add(nameBrand);
        ArrayList<Integer> idsBrands;
        idsBrands = controller.getAllIdsBrands();
        refBrandComboBox = new JComboBox<>();
        DefaultComboBoxModel<Integer> modelBrands = new DefaultComboBoxModel<>();
        modelBrands.addAll(idsBrands);
        refBrandComboBox.setModel(modelBrands);
        if(idsBrands.size() != 0)
            refBrandComboBox.setSelectedIndex(0);
        queryPanel1.add(refBrandComboBox);

        panel1.add(queryPanel1);
        panel1.add(buttonQuery1);
        panel1.setLayout(new GridLayout(2,1));
        add(panel1);





        panel2 = new JPanel();
        queryPanel2 = new JPanel();
        queryPanel2.setLayout(new GridLayout(1, 2));
        nameAffair = new JLabel("Affair Id");
        queryPanel2.add(nameAffair);
        ArrayList<Integer> idsAffairs;
        idsAffairs = controller.getAllIdsAffairs();

        DefaultComboBoxModel<Integer> modelAffairs = new DefaultComboBoxModel<>();
        modelBrands.addAll(idsAffairs);
        refAffairComboBox = new JComboBox<>();
        refAffairComboBox.setModel(modelAffairs);
        if(idsAffairs.size() != 0)
            refAffairComboBox.setSelectedIndex(0);
        queryPanel2.add(refAffairComboBox);

        panel2.add(queryPanel2);
        panel2.add(buttonQuery2);
        panel2.setLayout(new GridLayout(2,1));
        add(panel2);



        String[] days = {"1", "2" ,"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" ,"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] years = {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"};


        panel3 = new JPanel();
        queryPanel3 = new JPanel();
        queryPanel3.setLayout(new GridLayout(1, 2));
        date = new JLabel("Date");
        queryPanel3.add(date);
        panelDate = new JPanel();
        dateDay = new JComboBox<>(days);
        dateMonth = new JComboBox<>(months);
        dateYear = new JComboBox<>(years);
        panelDate.add(dateDay);
        panelDate.add(dateMonth);
        panelDate.add(dateYear);

        queryPanel3.add(panelDate);
        panel3.add(queryPanel3);
        panel3.add(buttonQuery3);
        panel3.setLayout(new GridLayout(2,1));
        add(panel3);

    }
}
