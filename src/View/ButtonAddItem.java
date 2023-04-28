package View;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class ButtonAddItem implements ActionListener {

    private JTextField codeText,nameText, catalogPriceText, packagingText, vatText, stockQuantityText, thresholdLimitText, refBrandText, reductionPointsText;
    private JComboBox<String> prodDay, prodMonth, prodYear;
    private JComboBox<String> saleDay, saleMonth, saleYear;
    private JRadioButton yesAutomaticOrder;
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

    public ButtonAddItem(JTextField codeText, JTextField refBrandText, JTextField nameText,
                         JTextField catalogPriceText, JTextField reductionPointsText,
                         JTextField packagingText, JTextField vatText, JTextField stockQuantityText,
                         JTextField thresholdLimitText, JRadioButton yesAutomaticOrder, JComboBox prodYear,
                         JComboBox prodMonth, JComboBox prodDay, JComboBox saleYear, JComboBox saleMonth,
                         JComboBox saleDay, JCheckBox optionalButtonProductionDate){
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
        this.optionalButtonProductionDate = optionalButtonProductionDate;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean isAttributed = false;
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
            System.out.println(item);
        }

    }






    public boolean setAttributeItem() throws AddCodeException, AddIntException, AddBigDecimalException, AddIntException {

        if(codeText.getText().matches("[0-9]+"))
            code = codeText.getText();
        else
            throw new AddCodeException(codeText.getText());

        if(codeText.getText().matches("[0-9]+"))
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
