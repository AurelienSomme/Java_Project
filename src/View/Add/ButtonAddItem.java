package View.Add;
import Controller.ApplicationController;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class ButtonAddItem implements ActionListener {

    private JTextField codeText,nameText, catalogPriceText, packagingText, vatText, stockQuantityText, thresholdLimitText, refBrandText, reductionPointsText;
    private JComboBox<String> prodDay, prodMonth, prodYear;
    private JComboBox<String> saleDay, saleMonth, saleYear;
    private JRadioButton yesAutomaticOrder, noAutomaticOrder;
    private Item item;

    private String code;
    private int refBrand;
    private String name;
    private BigDecimal catalogPrice;
    private BigDecimal reductionPoints;
    private String packaging;
    private BigDecimal VAT;
    private BigDecimal stockQuantity;
    private BigDecimal thresholdLimit;
    private boolean automaticOrder;
    private GregorianCalendar productionDate;
    private GregorianCalendar saleDate;
    private JCheckBox optionalButtonProductionDate;
    private ApplicationController controller;

    public ButtonAddItem(JTextField codeText, JTextField refBrandText, JTextField nameText,
                         JTextField catalogPriceText, JTextField reductionPointsText,
                         JTextField packagingText, JTextField vatText, JTextField stockQuantityText,
                         JTextField thresholdLimitText, JRadioButton yesAutomaticOrder, JRadioButton noAutomaticOrder, JComboBox prodYear,
                         JComboBox prodMonth, JComboBox prodDay, JComboBox saleYear, JComboBox saleMonth,
                         JComboBox saleDay, JCheckBox optionalButtonProductionDate, ApplicationController controller){
        this.codeText = codeText;
        this.nameText = nameText;
        this.catalogPriceText = catalogPriceText;
        this.packagingText = packagingText;
        this.vatText = vatText;
        this.stockQuantityText = stockQuantityText;
        this.thresholdLimitText = thresholdLimitText;
        this.refBrandText = refBrandText;
        this.reductionPointsText = reductionPointsText;
        this.prodDay = prodDay;
        this.prodMonth = prodMonth;
        this.prodYear = prodYear;
        this.saleYear = saleYear;
        this.saleMonth = saleMonth;
        this.saleDay = saleDay;
        this.yesAutomaticOrder = yesAutomaticOrder;
        this.noAutomaticOrder = noAutomaticOrder;
        this.optionalButtonProductionDate = optionalButtonProductionDate;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isAttributed = false;
        boolean isAdded;
        try {
            isAttributed = setAttributeItem();
        }
        catch (Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        if(isAttributed) {

            item = new Item(code, refBrand, name, catalogPrice, packaging, VAT, stockQuantity, thresholdLimit, automaticOrder, saleDate);

            if(optionalButtonProductionDate.isSelected()){
                productionDate = new GregorianCalendar(Integer.parseInt((String) prodYear.getSelectedItem()), Integer.parseInt((String) prodMonth.getSelectedItem()), Integer.parseInt((String) prodDay.getSelectedItem()));
                item.setProductionDate(productionDate);
            }

            if(!reductionPointsText.getText().isBlank()){
                if (reductionPointsText.getText().matches("[0-9]{1,}\\.{0,1}[0-9]{0,}")) {
                    reductionPoints = new BigDecimal(reductionPointsText.getText());
                    item.setReductionPoints(reductionPoints);
                }
                else
                    try {
                        throw new AddBigDecimalException(reductionPointsText.getText(), "Reduction Points");
                    } catch (AddBigDecimalException exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);;
                    }
            }
            try {
                isAdded = controller.addItem(item);
                if(isAdded) {
                    JOptionPane.showMessageDialog(null, "The item has been added", "Success", JOptionPane.INFORMATION_MESSAGE);
                    codeText.setText("");
                    refBrandText.setText("");
                    nameText.setText("");
                    catalogPriceText.setText("");
                    packagingText.setText("");
                    vatText.setText("");
                    stockQuantityText.setText("");
                    thresholdLimitText.setText("");
                    yesAutomaticOrder.setSelected(true);
                    noAutomaticOrder.setSelected(false);
                    prodDay.setSelectedIndex(0);
                    prodMonth.setSelectedIndex(0);
                    prodYear.setSelectedIndex(0);
                    saleDay.setSelectedIndex(0);
                    saleMonth.setSelectedIndex(0);
                    saleYear.setSelectedIndex(0);
                    optionalButtonProductionDate.setSelected(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "The item has not been added (code already in DB or ref_brand not in DB)", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }






    public boolean setAttributeItem() throws AddCodeException, AddIntException, AddBigDecimalException, AddIntException {

        if(!codeText.getText().isBlank())
            code = codeText.getText();
        else
            throw new AddCodeException(codeText.getText());

        if(refBrandText.getText().matches("[0-9]+"))
            refBrand = Integer.parseInt(refBrandText.getText());
        else
            throw new AddIntException(refBrandText.getText(), "Ref brand");

        if(!nameText.getText().isBlank())
            name = nameText.getText();
        else
            throw new AddIntException(nameText.getText(), "Name");

        if(catalogPriceText.getText().matches("[0-9]{1,}\\.{0,1}[0-9]{0,}"))
            catalogPrice = new BigDecimal(catalogPriceText.getText());
        else
            throw new AddBigDecimalException(catalogPriceText.getText(), "Catalog Price");

        if(!packagingText.getText().isBlank())
            packaging = packagingText.getText();
        else
            throw new AddIntException(packagingText.getText(), "Packaging");

        if(vatText.getText().matches("[0-9]{1,}\\.{0,1}[0-9]{0,}"))
            VAT = new BigDecimal(vatText.getText());
        else
            throw new AddBigDecimalException(vatText.getText(), "VAT");

        if(stockQuantityText.getText().matches("[0-9]{1,}\\.{0,1}[0-9]{0,}"))
            stockQuantity = new BigDecimal(stockQuantityText.getText());
        else
            throw new AddBigDecimalException(stockQuantityText.getText(), "Stock Quantity");

        if(thresholdLimitText.getText().matches("[0-9]{1,}\\.{0,1}[0-9]{0,}"))
            thresholdLimit = new BigDecimal(thresholdLimitText.getText());
        else
            throw new AddBigDecimalException(thresholdLimitText.getText(), "Treshold Limit");

        automaticOrder = yesAutomaticOrder.isSelected();
        saleDate = new GregorianCalendar(Integer.parseInt((String)saleYear.getSelectedItem()), Integer.parseInt((String)saleMonth.getSelectedItem()), Integer.parseInt((String)saleDay.getSelectedItem()));
        return true;
    }
}
