package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

    private static Connection connectionUnique;


    public static Boolean getInstance(String password) throws SQLException {
        if (connectionUnique == null) {

            try {
                connectionUnique = DriverManager.getConnection("jdbc:mysql://localhost:3306/project java", "root", password);
            }catch(Exception e){

            }
            if(connectionUnique == null){
                return false;
            }
        }
        return true;
    }


    public static Connection getInstance() {

        return connectionUnique;
    }


}