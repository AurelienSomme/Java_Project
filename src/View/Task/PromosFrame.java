package View.Task;

import Controller.ApplicationController;
import Model.PromoHistory;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class PromosFrame extends JFrame {

    private ApplicationController controller;
    private Container container;


    public PromosFrame(ApplicationController controller, ArrayList<PromoHistory> promoHistories){
        super("Promos History");

        this.controller = controller;
        setBounds(110, 35, 500, 600);
        setVisible(true);
        setResizable(false);
        container = getContentPane();
        container.add(new PromosPanel(promoHistories));
        revalidate();

    }
}
