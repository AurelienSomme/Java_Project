package View;

import Controller.ApplicationController;
import Model.AddBigDecimalException;
import Model.AddCodeException;
import Model.AddIntException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class ButtonUpdateItem implements ActionListener {
    private UpdateItemPanel updateItemPanel;
    private JTextField codeText,nameText, catalogPriceText, packagingText, vatText, stockQuantityText, thresholdLimitText, refBrandText, reductionPointsText;
    private JComboBox<String> prodDay, prodMonth, prodYear;
    private JComboBox<String> saleDay, saleMonth, saleYear;
    private JRadioButton yesAutomaticOrder, noAutomaticOrder;
    private JCheckBox optionalButtonCode, optionalButtonName, optionalButtonCatalogPrice, optionalButtonPackaging, optionalButtonVAT,
            optionalButtonStockQuantity, optionalButtonThresholdLimit, optionalButtonRefBrand, optionalButtonAutomaticOrder,
            optionalButtonSaleDate, optionalButtonReductionPoint,  optionalButtonProductionDate;
    private ApplicationController controller;
    private Map<String, Object> updateValues = new HashMap<>();
    private int codeItem;
    private JPanel main;




    public ButtonUpdateItem(JTextField codeText, JTextField refBrandText, JTextField nameText,
                            JTextField catalogPriceText, JTextField reductionPointsText,
                            JTextField packagingText, JTextField vatText, JTextField stockQuantityText,
                            JTextField thresholdLimitText, JRadioButton yesAutomaticOrder, JRadioButton noAutomaticOrder, JComboBox prodYear,
                            JComboBox prodMonth, JComboBox prodDay, JComboBox saleYear, JComboBox saleMonth,
                            JComboBox saleDay, JCheckBox optionalButtonProductionDate,JCheckBox optionalButtonCode,
                            JCheckBox optionalButtonName, JCheckBox optionalButtonCatalogPrice, JCheckBox optionalButtonPackaging,
                            JCheckBox optionalButtonVAT, JCheckBox optionalButtonStockQuantity, JCheckBox optionalButtonThresholdLimit,
                            JCheckBox optionalButtonRefBrand,  JCheckBox optionalButtonAutomaticOrder,
                            JCheckBox optionalButtonSaleDate, JCheckBox optionalButtonReductionPoint, ApplicationController controller, int codeItem,
                            JPanel main){
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
        this.optionalButtonCode = optionalButtonCode;
        this.optionalButtonName = optionalButtonName;
        this.optionalButtonCatalogPrice = optionalButtonCatalogPrice;
        this.optionalButtonPackaging = optionalButtonPackaging;
        this.optionalButtonVAT = optionalButtonVAT;
        this.optionalButtonStockQuantity = optionalButtonStockQuantity;
        this.optionalButtonThresholdLimit = optionalButtonThresholdLimit;
        this.optionalButtonRefBrand = optionalButtonRefBrand;
        this.optionalButtonAutomaticOrder = optionalButtonAutomaticOrder;
        this.optionalButtonSaleDate = optionalButtonSaleDate;
        this.optionalButtonReductionPoint = optionalButtonReductionPoint;
        this.controller = controller;
        this.codeItem = codeItem;
        this.main = main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            setUpdateValues();
            Boolean isUpdated = controller.updateItem(codeItem, updateValues);
            if(!isUpdated)
                JOptionPane.showMessageDialog(null, "The item has not been updated", "Error", JOptionPane.ERROR_MESSAGE);
            else{
                JOptionPane.showMessageDialog(null, "The item has been updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                main.removeAll();
                updateItemPanel = new UpdateItemPanel(controller);
                main.add(updateItemPanel);
                main.revalidate();
            }
        } catch (AddCodeException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (AddIntException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (AddBigDecimalException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    public void setUpdateValues()throws AddCodeException, AddIntException, AddBigDecimalException, AddIntException{

        if(optionalButtonCode.isSelected()){
            if(codeText.getText().matches("[0-9]+"))
                updateValues.put("code", codeText.getText());
            else
                throw new AddCodeException(codeText.getText());
        }
        if(optionalButtonName.isSelected()){
            if(!nameText.getText().isBlank())
                updateValues.put("name", nameText.getText());
            else
                throw new AddIntException(nameText.getText(), "Name");
        }
        if(optionalButtonCatalogPrice.isSelected()) {
            if(catalogPriceText.getText().matches("[0-9]{1,}\\.{0,1}[0-9]{0,}"))
                updateValues.put("catalog_price", catalogPriceText.getText());
            else
                throw new AddBigDecimalException(catalogPriceText.getText(), "Catalog Price");
        }
        if(optionalButtonReductionPoint.isSelected()) {
            if (reductionPointsText.getText().matches("[0-9]{1,}\\.{0,1}[0-9]{0,}"))
                updateValues.put("reduction_points", codeText.getText());
            else
                throw new AddBigDecimalException(reductionPointsText.getText(), "Reduction Points");
        }
        if(optionalButtonPackaging.isSelected()) {
            if (!packagingText.getText().isBlank())
                updateValues.put("packaging", packagingText.getText());
            else
                throw new AddIntException(packagingText.getText(), "Packaging");
        }
        if(optionalButtonVAT.isSelected()) {
            if(vatText.getText().matches("[0-9]{1,}\\.{0,1}[0-9]{0,}"))
                updateValues.put("VAT", vatText.getText());
            else
                throw new AddBigDecimalException(vatText.getText(), "VAT");
        }
        if(optionalButtonStockQuantity.isSelected()){
            if(stockQuantityText.getText().matches("[0-9]{1,}\\.{0,1}[0-9]{0,}"))
                updateValues.put("stock_quantity", stockQuantityText.getText());
            else
                throw new AddBigDecimalException(stockQuantityText.getText(), "Stock Quantity");
        }
        if(optionalButtonThresholdLimit.isSelected()){
            if(thresholdLimitText.getText().matches("[0-9]{1,}\\.{0,1}[0-9]{0,}"))
                updateValues.put("threshold_limit", thresholdLimitText.getText());
            else
                throw new AddBigDecimalException(thresholdLimitText.getText(), "Treshold Limit");
        }
        if(optionalButtonAutomaticOrder.isSelected()){
            updateValues.put("automatic_order", yesAutomaticOrder.isSelected());
        }
        if(optionalButtonProductionDate.isSelected()){
            updateValues.put("production_date", new GregorianCalendar(Integer.parseInt((String)saleYear.getSelectedItem()), Integer.parseInt((String)saleMonth.getSelectedItem()), Integer.parseInt((String)saleDay.getSelectedItem())));
        }
        if(optionalButtonSaleDate.isSelected()){
            updateValues.put("sale_date", new GregorianCalendar(Integer.parseInt((String) prodYear.getSelectedItem()), Integer.parseInt((String) prodMonth.getSelectedItem()), Integer.parseInt((String) prodDay.getSelectedItem())));
        }

    }


}
