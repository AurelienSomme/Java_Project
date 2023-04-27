package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class MainJFrame extends JFrame {

    private Container container;

    private JMenuBar menuBar;
    private JMenu menuItem, menuSearch, menuApplication;

    private JMenuItem addMenu, deleteMenu, updateMenu, displayMenu;
    private JMenuItem queryMenu, taskMenu;
    private JMenuItem quitMenu;

    private JPanel main;
    private Footer footer;

    private ImageShop[] imageShops = new ImageShop[6];


    public MainJFrame(){

        super("Shop Application");

        setBounds(80, 15, 1200, 800);


        //Allow closing program with the red cross
        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e){
                System.exit(0);
            }
        });


        //Load IMGs
        BufferedImage img = null;
        File path = new File("Icons");
        int i = 0;
        for (File file : path.listFiles()) {
            try {
                img = ImageIO.read(file);
                if (img != null) {
                    imageShops[i] = new ImageShop(img, (i % 2  == 0) ? 0 : 1);
                    i++;
                }
            } catch (IOException e) {
                continue;
            }
        }


        setVisible(true);

        container = getContentPane();

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuItem = new JMenu("Item");
        menuSearch = new JMenu("Search");
        menuApplication = new JMenu("Application");

        addMenu = new JMenuItem("Add");
        deleteMenu = new JMenuItem("Delete");
        updateMenu = new JMenuItem("Update");
        displayMenu = new JMenuItem("Display");
        queryMenu = new JMenuItem("Query");
        taskMenu = new JMenuItem("Task");
        quitMenu = new JMenuItem("Quit");

        menuItem.add(addMenu);
        menuItem.add(deleteMenu);
        menuItem.add(updateMenu);
        menuItem.add(displayMenu);
        menuSearch.add(queryMenu);
        menuSearch.add(taskMenu);
        menuApplication.add(quitMenu);

        menuBar.add(menuItem);
        menuBar.add(menuSearch);
        menuBar.add(menuApplication);



        main = new JPanel();
        footer = new Footer(imageShops, this);

        footer.setPreferredSize(new Dimension(this.getWidth(), 50));
        container.add(main,BorderLayout.CENTER);
        container.add(footer,BorderLayout.SOUTH);

        MovementThread movementImage = new MovementThread(imageShops, footer, this);
        movementImage.start();

        ButtonAddItemPanel buttonAddItemPanel = new ButtonAddItemPanel(main);
        addMenu.addActionListener(buttonAddItemPanel);

        ButtonDeleteItemPanel buttonDeleteItemPanel = new ButtonDeleteItemPanel(main);
        deleteMenu.addActionListener(buttonDeleteItemPanel);


        //Refresh display
        revalidate();



    }

}
