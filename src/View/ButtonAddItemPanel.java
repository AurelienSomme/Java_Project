package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAddItemPanel implements ActionListener {

    private JPanel addItemPanel;

    private Container container;

    public ButtonAddItemPanel(Container container){
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        container.removeAll();
        addItemPanel = new AddItemPanel();
        container.revalidate();
        container.add(addItemPanel);
    }
}
