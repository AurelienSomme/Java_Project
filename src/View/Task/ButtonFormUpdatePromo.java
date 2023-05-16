package View.Task;

import Controller.ApplicationController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFormUpdatePromo implements ActionListener {
    private ApplicationController controller;
    private Container container;
    private String code;
    public ButtonFormUpdatePromo(ApplicationController controller, Container container, String code){
        this.controller = controller;
        this.container = container;
        this.code = code;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        container.removeAll();
        container.add(new FormUpdatePromoPanel(controller, code, container));
        container.revalidate();
    }
}
