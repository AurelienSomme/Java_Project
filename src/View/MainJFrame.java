package View;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainJFrame extends JFrame {

    public MainJFrame(){

        super("Shop Application");

        setBounds(80, 15, 1200, 800);


        //Allow to close program with the red cross
        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e){
                System.exit(0);
            }
        });

        setVisible(true);

    }

}
