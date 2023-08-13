package DataAccess;


import Model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BrandDBAccess implements BrandDataAccess{

    private Connection connection;

    public BrandDBAccess(){
        connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<String> getAllIdsBrands() throws SQLException {
        ArrayList<String> idsBrands = new ArrayList<>();
        String allIdsInstruction = "SELECT id_brand, name from brand;";
        PreparedStatement preparedStatement = connection.prepareStatement(allIdsInstruction);
        ResultSet data = preparedStatement.executeQuery();

        while (data.next()){
            idsBrands.add(data.getInt("id_brand") + " - " + data.getString("name"));
        }

        return idsBrands;
    }


    @Override
    public ArrayList<Brand> getAllBrands() throws SQLException{
        ArrayList<Brand> brands = new ArrayList<>();
        String instruction = "SELECT * FROM brand;";
        PreparedStatement preparedStatement = connection.prepareStatement(instruction);
        ResultSet data = preparedStatement.executeQuery();

        while (data.next()){
            Brand brand;
            LocalDate creationDate = data.getDate("creation_date").toLocalDate();
            brand = new Brand(data.getInt("id_brand"), data.getString("name"), data.getString("CEO"), creationDate);
            if(data.getString("description") != null)
                brand.setDescription(data.getString("description"));
            brands.add(brand);
        }

        return brands;
    }
}
