package View.Query;

import Controller.ApplicationController;
import Model.PromoItemBrand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ButtonPromoBrand implements ActionListener {

    private QueryPanel main;
    private ApplicationController controller;
    private JComboBox<String> refBrandComboBox;
    private int refBrand;

    public ButtonPromoBrand(QueryPanel main, ApplicationController controller, JComboBox<String> refBrandComboBox){
        this.main = main;
        this.controller = controller;
        this.refBrandComboBox = refBrandComboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (refBrandComboBox.getItemCount() != 0){
            Object[][] promosItemBrand;
            String selectedBrand = (String) refBrandComboBox.getSelectedItem();
            String[] brandStr = selectedBrand.split(" - ", 2);
            String refStr = brandStr[0].trim();
            refBrand = Integer.parseInt(refStr);
            try {
                promosItemBrand = controller.getPromosItemBrand(refBrand);

                main.removeAll();
                main.add(new DisplayPromosPanel(controller, promosItemBrand));
                main.revalidate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
}
