package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDeleteItemPanel implements ActionListener {
    private JPanel deleteItemPanel;

    private JPanel main;

    public ButtonDeleteItemPanel(JPanel main){
        this.main = main;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        main.removeAll();
        deleteItemPanel = new DeleteItemPanel();
        main.revalidate();
        main.add(deleteItemPanel);
    }
}
