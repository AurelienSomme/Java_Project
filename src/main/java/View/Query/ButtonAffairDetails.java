package View.Query;

import Controller.ApplicationController;
import Model.AffairDetail;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ButtonAffairDetails implements ActionListener {

    private QueryPanel main;
    private ApplicationController controller;
    private JComboBox<Integer> refAffairComboBox;
    private int idAffair;

    public ButtonAffairDetails(QueryPanel main, ApplicationController controller, JComboBox<Integer> refAffairComboBox){
        this.main = main;
        this.controller = controller;
        this.refAffairComboBox = refAffairComboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (refAffairComboBox.getItemCount() != 0){
            Object[][] affairDetails;
            Integer selectedIdAffair = (Integer) refAffairComboBox.getSelectedItem();
            idAffair = selectedIdAffair.intValue();
            try {
                affairDetails = controller.getAffairDetails(idAffair);

                main.removeAll();
                main.add(new DisplayAffairDetailsPanel(controller, affairDetails));
                main.revalidate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
}
