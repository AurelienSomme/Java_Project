package DataAccess;

import Model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDBAccess implements ItemDataAccess{

    private SingletonConnection singletonConnexion;
    private Connection connection;

    public ItemDBAccess() throws SQLException {
        singletonConnexion = SingletonConnection.getInstance();
        connection = singletonConnexion.getConnection();
    }

    @Override
    public ArrayList<Item> getAllItems() throws SQLException {
        return null;
    }

    @Override
    public boolean addItem(Item item) throws SQLException {

        String checkingBrandInstruction = "SELECT EXISTS (SELECT 1 FROM Brand WHERE id_brand = ?)";
        PreparedStatement preparedStatementCheckingBrand = connection.prepareStatement(checkingBrandInstruction);

        preparedStatementCheckingBrand.setInt(1, item.getRefBrand());
        ResultSet resultSet = preparedStatementCheckingBrand.executeQuery();
        boolean brandExists = false;
        if (resultSet.next()) {
            brandExists = resultSet.getInt(1) == 1;
        }
        if(brandExists) {

            String sqlInstruction = "INSERT INTO item VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            preparedStatement.setInt(1, Integer.parseInt(item.getCode()));
            preparedStatement.setInt(2, item.getRefBrand());
            preparedStatement.setString(3, item.getName());
            preparedStatement.setBigDecimal(4, item.getCatalogPrice());
            if (item.getReductionPoints() != null)
                preparedStatement.setBigDecimal(5, item.getReductionPoints());
            else
                preparedStatement.setBigDecimal(5, null);
            preparedStatement.setString(6, item.getPackaging());
            preparedStatement.setBigDecimal(7, item.getVAT());
            preparedStatement.setBigDecimal(8, item.getStockQuantity());
            preparedStatement.setBigDecimal(9, item.getThresholdLimit());
            preparedStatement.setBoolean(10, item.getAutomaticOrder());
            if (item.getProductionDate() != null)
                preparedStatement.setDate(11, new java.sql.Date(item.getProductionDate().getTimeInMillis()));
            else
                preparedStatement.setDate(11, null);
            preparedStatement.setDate(12, new java.sql.Date(item.getSaleDate().getTimeInMillis()));

            try {
                preparedStatement.executeUpdate();
                return true;
            }catch (Exception e){
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public boolean deleteItem(String code) throws SQLException {
        String deleteInstruction = "DELETE FROM item where code = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteInstruction);
        preparedStatement.setString(1, code);
        int nbUpdatedLines = preparedStatement.executeUpdate();
        return (nbUpdatedLines != 0);
    }
}
