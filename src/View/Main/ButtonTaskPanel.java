package View.Main;

import Controller.ApplicationController;
import View.Task.TaskJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTaskPanel implements ActionListener {

    private ApplicationController controller;
    private TaskJFrame taskJFrame;

    public ButtonTaskPanel(ApplicationController controller){
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        taskJFrame = new TaskJFrame(controller);
    }
}
