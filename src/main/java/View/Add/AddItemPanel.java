package View.Add;

import Controller.ApplicationController;
import View.Optional.ButtonOptionalDate;

import javax.swing.*;
import java.awt.*;

public class AddItemPanel extends JPanel {
    //Panels
    private JPanel itemFormPanel;
    private JPanel orderPanel, dateSalePanel, dateProdPanel, dateProdForm;
    private JPanel buttonPanel;
    private JPanel elementsPanel;

    //Labels
    private JLabel code, name, catalogPrice, packaging, vat, stockQuantity, thresholdLimit, refBrand, automaticOrder, saleDate;
    //Optional
    private JLabel reductionPoint, productionDate;

    //Items form
    private JTextField codeText, nameText, catalogPriceText, packagingText, vatText, stockQuantityText, thresholdLimitText, refBrandText;
    private JRadioButton yesAutomaticOrder, noAutomaticOrder;
    private ButtonGroup groupAutomaticOrder;
    private JComboBox<String> saleDay, saleMonth, saleYear;
    //Optional
    private JTextField reductionPointText;
    private JComboBox<String> prodDay, prodMonth, prodYear;
    private JCheckBox optionalButtonProductionDate;

    private JButton addItem;

    private ApplicationController controller;

    public AddItemPanel(ApplicationController controller){
        this.controller = controller;
        //Init Labels
        code = new JLabel("Code");
        name = new JLabel("Name");
        catalogPrice = new JLabel("Catalog Price");
        packaging = new JLabel("Packaging");
        vat = new JLabel("VAT");
        stockQuantity = new JLabel("Stock Quantity");
        thresholdLimit = new JLabel("Threshold Limit");
        refBrand = new JLabel("Ref Brand");
        automaticOrder = new JLabel("Automatic Order");
        saleDate = new JLabel("Sale Date");
        //Optional
        reductionPoint = new JLabel("Reduction Points");
        productionDate = new JLabel("Production Date");

        //Init items
        codeText = new JTextField();
        nameText = new JTextField();
        catalogPriceText = new JTextField();
        packagingText = new JTextField();
        vatText = new JTextField();
        stockQuantityText = new JTextField();
        thresholdLimitText = new JTextField();
        refBrandText = new JTextField();

        groupAutomaticOrder = new ButtonGroup();
        yesAutomaticOrder = new JRadioButton("Yes", true);
        noAutomaticOrder = new JRadioButton("No", false);
        groupAutomaticOrder.add(yesAutomaticOrder);
        groupAutomaticOrder.add(noAutomaticOrder);

        String[] days = {"1", "2" ,"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" ,"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] years = {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"};

        saleDay = new JComboBox<>(days);
        saleMonth =  new JComboBox<>(months);
        saleYear = new JComboBox<>(years);
        dateSalePanel = new JPanel();
        dateSalePanel.add(saleDay);
        dateSalePanel.add(saleMonth);
        dateSalePanel.add(saleYear);


        //Optional
        optionalButtonProductionDate = new JCheckBox("Yes", false);
        prodDay = new JComboBox<>(days);
        prodMonth = new JComboBox<>(months);
        prodYear = new JComboBox<>(years);
        prodDay.setEnabled(false);
        prodMonth.setEnabled(false);
        prodYear.setEnabled(false);
        dateProdForm = new JPanel();
        dateProdPanel = new JPanel();
        dateProdPanel.add(prodDay);
        dateProdPanel.add(prodMonth);
        dateProdPanel.add(prodYear);

        ButtonOptionalDate listenerCheckDate = new ButtonOptionalDate(prodDay, prodMonth, prodYear, optionalButtonProductionDate);
        optionalButtonProductionDate.addActionListener(listenerCheckDate);

        dateProdForm.add(optionalButtonProductionDate);
        dateProdForm.add(dateProdPanel);
        dateProdForm.setLayout(new GridLayout(1,2));
        reductionPointText = new JTextField();

        itemFormPanel = new JPanel();

        itemFormPanel.add(code);
        itemFormPanel.add(codeText);

        itemFormPanel.add(name);
        itemFormPanel.add(nameText);

        itemFormPanel.add(catalogPrice);
        itemFormPanel.add(catalogPriceText);

        itemFormPanel.add(packaging);
        itemFormPanel.add(packagingText);

        itemFormPanel.add(vat);
        itemFormPanel.add(vatText);

        itemFormPanel.add(stockQuantity);
        itemFormPanel.add(stockQuantityText);

        itemFormPanel.add(thresholdLimit);
        itemFormPanel.add(thresholdLimitText);

        itemFormPanel.add(refBrand);
        itemFormPanel.add(refBrandText);

        itemFormPanel.add(automaticOrder);


        orderPanel = new JPanel();



        orderPanel.add(yesAutomaticOrder);
        orderPanel.add(noAutomaticOrder);

        itemFormPanel.add(orderPanel);


        itemFormPanel.add(saleDate);
        itemFormPanel.add(dateSalePanel);

        itemFormPanel.add(reductionPoint);
        itemFormPanel.add(reductionPointText);

        itemFormPanel.add(productionDate);
        itemFormPanel.add(dateProdForm);



        itemFormPanel.setLayout(new GridLayout(12, 2));

        addItem = new JButton("Add");
        ButtonAddItem buttonAddItem = new ButtonAddItem(codeText, refBrandText,
                nameText, catalogPriceText, reductionPointText, packagingText, vatText,
                stockQuantityText, thresholdLimitText, yesAutomaticOrder, noAutomaticOrder, prodYear, prodMonth,
                prodDay, saleYear, saleMonth, saleDay, optionalButtonProductionDate, controller);

        addItem.addActionListener(buttonAddItem);

        buttonPanel = new JPanel();

        buttonPanel.add(addItem);



        elementsPanel = new JPanel();
        elementsPanel.setLayout(new GridLayout(2, 1));

        elementsPanel.add(itemFormPanel);
        elementsPanel.add(buttonPanel);

        add(elementsPanel);


    }

}
