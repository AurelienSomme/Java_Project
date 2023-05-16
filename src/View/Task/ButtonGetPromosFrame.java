package View.Task;

import Controller.ApplicationController;
import Model.PromoHistory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ButtonGetPromosFrame implements ActionListener {

    private String code;
    private ApplicationController controller;

    public ButtonGetPromosFrame(String code, ApplicationController controller){
        this.controller = controller;
        this.code = code;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<PromoHistory> promoHistories;
        try {
            promoHistories = controller.getPromoHistories(code);
            PromosFrame promosFrame = new PromosFrame(controller, promoHistories);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
