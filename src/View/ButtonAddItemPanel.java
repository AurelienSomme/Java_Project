package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAddItemPanel implements ActionListener {

    private JPanel addItemPanel;

    private JPanel main;

    public ButtonAddItemPanel(JPanel main){
        this.main = main;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        main.removeAll();
        addItemPanel = new AddItemPanel();
        main.revalidate();
        main.add(addItemPanel);
    }
}
