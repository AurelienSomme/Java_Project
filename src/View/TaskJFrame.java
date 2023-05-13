package View;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.*;

public class TaskJFrame extends JFrame {

    private ApplicationController controller;
    private Container container;
    private TaskPanel taskPanel;

    public TaskJFrame(ApplicationController controller){
        super("Shop Task");
        this.controller = controller;
        setBounds(110, 35, 800, 600);
        setVisible(true);

        container = getContentPane();

        taskPanel = new TaskPanel(controller);
        container.add(taskPanel);

        revalidate();
    }
}
