package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainJFrame extends JFrame {

    private Container container;

    private JMenuBar menuBar;
    private JMenu menuItem, menuSearch, menuApplication;

    private JMenuItem addMenu, deleteMenu, updateMenu, displayMenu;
    private JMenuItem queryMenu, taskMenu;
    private JMenuItem quitMenu;

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


        //Refresh display
        revalidate();



    }

}
