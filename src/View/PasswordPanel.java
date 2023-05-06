package View;



import javax.swing.*;


public class PasswordPanel extends JPanel {
    private MainJFrame mainJFrame;
    public PasswordPanel(MainJFrame mainJFrame) {
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');
        this.mainJFrame = mainJFrame;

        JButton button = new JButton("Enter");

        ButtonDBConnection buttonDBConnection = new ButtonDBConnection(passwordField, mainJFrame);
        button.addActionListener(buttonDBConnection);

        this.add(passwordLabel);
        this.add(passwordField);
        this.add(button);
    }
}