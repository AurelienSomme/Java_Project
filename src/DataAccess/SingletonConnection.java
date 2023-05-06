package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

    private static SingletonConnection UniqueInstance;
    private static Connection connection;


    private SingletonConnection(){

    }

    public static Boolean getInstance(String password) throws SQLException {
        if (UniqueInstance == null) {

            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet java magasin", "root", password);
            }catch(Exception e){

            }
            if(connection == null){
                return false;
            }
            UniqueInstance = new SingletonConnection();
        }
        return true;
    }


    public static SingletonConnection getInstance() {
        if (UniqueInstance == null) {
            UniqueInstance = new SingletonConnection();
        }
        return UniqueInstance;
    }



    public static Connection getConnection(){
        return connection;
    }


}