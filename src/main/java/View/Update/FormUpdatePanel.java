package View.Update;

import Controller.ApplicationController;
import Model.Item;
import View.Optional.ButtonOptionalDate;
import View.Optional.ButtonOptionalRadio;
import View.Optional.ButtonOptionalText;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class FormUpdatePanel extends JPanel {
    private Item item;
    private ApplicationController controller;
    private JPanel main;

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
    private JTextField nameText, catalogPriceText, packagingText, vatText, stockQuantityText, thresholdLimitText;
    private JRadioButton yesAutomaticOrder, noAutomaticOrder;
    private ButtonGroup groupAutomaticOrder;
    private JComboBox<String> saleDay, saleMonth, saleYear;
    //Optional
    private JTextField reductionPointText;
    private JComboBox<String> prodDay, prodMonth, prodYear;
    private JCheckBox optionalButtonName, optionalButtonCatalogPrice, optionalButtonPackaging, optionalButtonVAT,
            optionalButtonStockQuantity, optionalButtonThresholdLimit, optionalButtonAutomaticOrder,
            optionalButtonSaleDate, optionalButtonReductionPoint,  optionalButtonProductionDate;

    private JButton updateItemButton;

    private SimpleDateFormat formatter;

    public FormUpdatePanel(Item item, ApplicationController controller, JPanel main){
        this.main = main;
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.item = item;
        this.controller = controller;

        name = new JLabel("Name : " + item.getName());
        catalogPrice = new JLabel("Catalog Price : " + item.getCatalogPrice());
        packaging = new JLabel("Packaging : " + item.getPackaging());
        vat = new JLabel("VAT : " + item.getVAT());
        stockQuantity = new JLabel("Stock Quantity : " + item.getStockQuantity());
        thresholdLimit = new JLabel("Threshold Limit : " + item.getThresholdLimit());

        automaticOrder = new JLabel("Automatic Order : " + item.getAutomaticOrder());
        saleDate = new JLabel("Sale Date : " + item.getSaleDate().toString());
        //Optional
        reductionPoint = new JLabel("Reduction Points : " + item.getReductionPoints());
        productionDate = new JLabel("Prod Date : " + (item.getProductionDate() == null ? "null" : item.getProductionDate().toString()));
        //Init items

        nameText = new JTextField();
        catalogPriceText = new JTextField();
        packagingText = new JTextField();
        vatText = new JTextField();
        stockQuantityText = new JTextField();
        thresholdLimitText = new JTextField();


        groupAutomaticOrder = new ButtonGroup();
        yesAutomaticOrder = new JRadioButton("Yes", true);
        noAutomaticOrder = new JRadioButton("No", false);
        groupAutomaticOrder.add(yesAutomaticOrder);
        groupAutomaticOrder.add(noAutomaticOrder);

        String[] days = {"1", "2" ,"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" ,"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] years = {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"};

        saleDay = new JComboBox<>(days);
        saleMonth =  new JComboBox<>(months);
        saleYear = new JComboBox<>(years);
        dateSalePanel = new JPanel();
        dateSalePanel.add(saleDay);
        dateSalePanel.add(saleMonth);
        dateSalePanel.add(saleYear);


        //Optional
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


        dateProdForm.add(dateProdPanel);
        dateProdForm.setLayout(new GridLayout(1,2));
        reductionPointText = new JTextField();

        itemFormPanel = new JPanel();



        optionalButtonName = new JCheckBox();
        ButtonOptionalText buttonOptionalTextName = new ButtonOptionalText(nameText, optionalButtonName);
        optionalButtonName.addActionListener(buttonOptionalTextName);
        nameText.setEnabled(false);
        itemFormPanel.add(name);
        itemFormPanel.add(optionalButtonName);
        itemFormPanel.add(nameText);


        optionalButtonCatalogPrice = new JCheckBox();
        ButtonOptionalText buttonOptionalTextCatalogPrice = new ButtonOptionalText(catalogPriceText, optionalButtonCatalogPrice);
        optionalButtonCatalogPrice.addActionListener(buttonOptionalTextCatalogPrice);
        catalogPriceText.setEnabled(false);
        itemFormPanel.add(catalogPrice);
        itemFormPanel.add(optionalButtonCatalogPrice);
        itemFormPanel.add(catalogPriceText);

        optionalButtonPackaging = new JCheckBox();
        ButtonOptionalText buttonOptionalTextPackaging = new ButtonOptionalText(packagingText, optionalButtonPackaging);
        optionalButtonPackaging.addActionListener(buttonOptionalTextPackaging);
        packagingText.setEnabled(false);
        itemFormPanel.add(packaging);
        itemFormPanel.add(optionalButtonPackaging);
        itemFormPanel.add(packagingText);
        optionalButtonVAT = new JCheckBox();
        ButtonOptionalText buttonOptionalTextVAT = new ButtonOptionalText(vatText, optionalButtonVAT);
        optionalButtonVAT.addActionListener(buttonOptionalTextVAT);
        vatText.setEnabled(false);
        itemFormPanel.add(vat);
        itemFormPanel.add(optionalButtonVAT);
        itemFormPanel.add(vatText);

        optionalButtonStockQuantity = new JCheckBox();
        ButtonOptionalText buttonOptionalTextStockQuantity = new ButtonOptionalText(stockQuantityText, optionalButtonStockQuantity);
        optionalButtonStockQuantity.addActionListener(buttonOptionalTextStockQuantity);
        stockQuantityText.setEnabled(false);
        itemFormPanel.add(stockQuantity);
        itemFormPanel.add(optionalButtonStockQuantity);
        itemFormPanel.add(stockQuantityText);


        optionalButtonThresholdLimit = new JCheckBox();
        ButtonOptionalText buttonOptionalTextThresholdLimit = new ButtonOptionalText(thresholdLimitText,optionalButtonThresholdLimit );
        optionalButtonThresholdLimit.addActionListener(buttonOptionalTextThresholdLimit);
        thresholdLimitText.setEnabled(false);
        itemFormPanel.add(thresholdLimit);
        itemFormPanel.add(optionalButtonThresholdLimit);
        itemFormPanel.add(thresholdLimitText);



        optionalButtonAutomaticOrder = new JCheckBox();
        ButtonOptionalRadio buttonOptionalRadioAutomaticOrder = new ButtonOptionalRadio(yesAutomaticOrder, noAutomaticOrder, optionalButtonAutomaticOrder);
        optionalButtonAutomaticOrder.addActionListener(buttonOptionalRadioAutomaticOrder);
        yesAutomaticOrder.setEnabled(false);
        noAutomaticOrder.setEnabled(false);
        itemFormPanel.add(automaticOrder);
        itemFormPanel.add(optionalButtonAutomaticOrder);
        orderPanel = new JPanel();
        orderPanel.add(yesAutomaticOrder);
        orderPanel.add(noAutomaticOrder);

        itemFormPanel.add(orderPanel);

        optionalButtonSaleDate = new JCheckBox();
        ButtonOptionalDate buttonOptionalDateSale = new ButtonOptionalDate(saleDay, saleMonth, saleYear, optionalButtonSaleDate);
        optionalButtonSaleDate.addActionListener(buttonOptionalDateSale);
        saleDay.setEnabled(false);
        saleMonth.setEnabled(false);
        saleYear.setEnabled(false);
        itemFormPanel.add(saleDate);
        itemFormPanel.add(optionalButtonSaleDate);
        itemFormPanel.add(dateSalePanel);

        optionalButtonReductionPoint = new JCheckBox();
        ButtonOptionalText buttonOptionalTextReductionPoint = new ButtonOptionalText(reductionPointText, optionalButtonReductionPoint);
        optionalButtonReductionPoint.addActionListener(buttonOptionalTextReductionPoint);
        reductionPointText.setEnabled(false);
        itemFormPanel.add(reductionPoint);
        itemFormPanel.add(optionalButtonReductionPoint);
        itemFormPanel.add(reductionPointText);

        optionalButtonProductionDate = new JCheckBox();
        ButtonOptionalDate listenerCheckDate = new ButtonOptionalDate(prodDay, prodMonth, prodYear, optionalButtonProductionDate);
        optionalButtonProductionDate.addActionListener(listenerCheckDate);
        itemFormPanel.add(productionDate);
        itemFormPanel.add(optionalButtonProductionDate);
        itemFormPanel.add(dateProdForm);



        itemFormPanel.setLayout(new GridLayout(10, 3));
        updateItemButton = new JButton("Update");
        ButtonUpdateItem buttonUpdateItem = new ButtonUpdateItem( nameText, catalogPriceText, reductionPointText, packagingText, vatText,
                stockQuantityText, thresholdLimitText, yesAutomaticOrder, noAutomaticOrder, prodYear, prodMonth,
                prodDay, saleYear, saleMonth, saleDay, optionalButtonProductionDate , optionalButtonName,  optionalButtonCatalogPrice,  optionalButtonPackaging,
                optionalButtonVAT,  optionalButtonStockQuantity,  optionalButtonThresholdLimit,
                optionalButtonAutomaticOrder,
                optionalButtonSaleDate,  optionalButtonReductionPoint, controller, item.getCode(),
                main);

        updateItemButton.addActionListener(buttonUpdateItem);
        buttonPanel = new JPanel();

        buttonPanel.add(updateItemButton);

        elementsPanel = new JPanel();
        elementsPanel.setLayout(new GridLayout(2, 1));

        elementsPanel.add(itemFormPanel);
        elementsPanel.add(buttonPanel);

        add(elementsPanel);
    }
}
