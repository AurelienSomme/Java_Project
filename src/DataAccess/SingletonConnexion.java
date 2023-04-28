package DataAccess;

import java.sql.*;
import javax.swing.*;

public class SingletonConnexion {
    private static Connection singleConnection;
    private static Connection connection;
    private static String password;

    private SingletonConnexion(){

    }

    public static Connection getInstance() throws SQLException{
        if (singleConnection == null){
            singleConnection = new SingletonConnexion();
            boolean retry = true;

            char[] charpassword;
            JPanel panelPassword = new JPanel();
            JLabel labelPassword = new JLabel("DataBase password:");
            JPasswordField pass = new JPasswordField(10);
            panelPassword.add(labelPassword);
            panelPassword.add(pass);
            String[] options = new String[]{"OK", "Leave"};
            int option = 0;

            do {
                try {
                    option = JOptionPane.showOptionDialog(null, panelPassword, "Password",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options, options[0]);
                    password = new String(pass.getPassword());
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", password);
                } catch (Exception e) {

                }
                if(option != 0)
                    System.exit(0);
                if(connection == null){
                    retry = JOptionPane.showConfirmDialog(null, "Wrong password!\nRetry ?", "Wrong password", JOptionPane.YES_NO_OPTION) == 1 ? false : true;
                }
                if(!retry)
                    System.exit(0);
            }while(connection == null && retry);
        }
        return singleConnection;
    }

    public static Connection getConnection(){return connection;}
}
