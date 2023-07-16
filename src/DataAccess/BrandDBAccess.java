package DataAccess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandDBAccess implements BrandDataAccess{

    private Connection connection;

    public BrandDBAccess(){
        connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Integer> getAllIdsBrands() throws SQLException {
        ArrayList<Integer> idsBrands = new ArrayList<>();
        String allIdsInstruction = "SELECT id_brand from brand;";
        PreparedStatement preparedStatement = connection.prepareStatement(allIdsInstruction);
        ResultSet data = preparedStatement.executeQuery();

        while (data.next()){
            idsBrands.add(data.getInt("id_brand"));
        }

        return idsBrands;
    }
}
