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
    private JComboBox<Integer> refBrandComboBox;
    private int refBrand;

    public ButtonPromoBrand(QueryPanel main, ApplicationController controller, JComboBox<Integer> refBrandComboBox){
        this.main = main;
        this.controller = controller;
        this.refBrandComboBox = refBrandComboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (refBrandComboBox.getItemCount() != 0){
            Object[][] promosItemBrand;
            Integer selectedRefBrand = (Integer) refBrandComboBox.getSelectedItem();
            refBrand = selectedRefBrand.intValue();
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
