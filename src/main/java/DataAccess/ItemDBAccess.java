package DataAccess;

import Model.Item;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;

public class ItemDBAccess implements ItemDataAccess{

    private Connection connection;

    public ItemDBAccess() throws SQLException {
        connection = SingletonConnection.getInstance();
    }


    public Item getItem(String code) throws SQLException {
        String getItemInstruction = "select * from item where code = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(getItemInstruction);
        preparedStatement.setString(1, code);
        ResultSet data = preparedStatement.executeQuery();
        Item item = null;
        while (data.next()) {
            LocalDate localProdDate = LocalDate.now(); // Date actuelle
            LocalDate localSaleDate = data.getDate("sale_date").toLocalDate(); // Conversion en LocalDate

            item = new Item(data.getString("code"), data.getInt("ref_brand"), data.getString("name"),
                    data.getBigDecimal("catalog_price"), data.getString("packaging"),
                    data.getBigDecimal("VAT"), data.getBigDecimal("stock_quantity"),
                    data.getBigDecimal("threshold_limit"), data.getBoolean("automatic_order"),
                    localSaleDate);
            if (data.getDate("production_date") != null) {
                localProdDate = data.getDate("production_date").toLocalDate();
                item.setProductionDate(localProdDate);
            }
            if (data.getBigDecimal("reduction_points") != null) {
                item.setReductionPoints(data.getBigDecimal("reduction_points"));
            }
        }
        return item;
    }

    @Override
    public ArrayList<Item> getAllItems() throws SQLException {
        String getAllItemsInstruction = "select * from item;";

        PreparedStatement preparedStatement = connection.prepareStatement(getAllItemsInstruction);
        ResultSet data = preparedStatement.executeQuery();

        ArrayList<Item> allItems = new ArrayList<>();

        Item item;

        while (data.next()){

            LocalDate localProdDate = LocalDate.now();
            LocalDate localSaleDate = data.getDate("sale_date").toLocalDate();

            item = new Item(data.getString("code"),data.getInt("ref_brand"), data.getString("name"),
                    data.getBigDecimal("catalog_price"), data.getString("packaging"),
                    data.getBigDecimal("VAT"), data.getBigDecimal("stock_quantity"),
                    data.getBigDecimal("threshold_limit"), data.getBoolean("automatic_order"),
                    localSaleDate);

            if(data.getDate("production_date") != null){
                localProdDate = data.getDate("production_date").toLocalDate();
                item.setProductionDate(localProdDate);
            }
            if(data.getBigDecimal("reduction_points") != null){
                item.setReductionPoints(data.getBigDecimal("reduction_points"));
            }

            allItems.add(item);
        }

        return allItems;
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
            preparedStatement.setString(1, item.getCode());
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
            Date sqlDate1;
            if (item.getProductionDate() != null) {
                sqlDate1 = Date.valueOf(item.getProductionDate());
                preparedStatement.setDate(11, sqlDate1);
            }
            else
                preparedStatement.setDate(11, null);
            Date sqlDate2 = Date.valueOf(item.getSaleDate());
            preparedStatement.setDate(12, sqlDate2);

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


    @Override
    public Boolean updateItem(String code, Map<String, Object> updateValues) throws SQLException {
        String updateInstructionHead = "UPDATE item SET ";
        String updateInstructionBody = "";
        String updateInstructionWhere = "WHERE code = ?";
        int i = 1;
        for (Map.Entry<String, Object> entry : updateValues.entrySet()) {
            updateInstructionBody += entry.getKey() + " = ?";
            if (i < updateValues.size())
                updateInstructionBody += ", ";
            i++;
        }
        String updateInstruction = updateInstructionHead + updateInstructionBody + " " + updateInstructionWhere;
        PreparedStatement preparedStatement = connection.prepareStatement(updateInstruction);

        i = 1;
        for (Map.Entry<String, Object> entry : updateValues.entrySet()) {
            Object value = entry.getValue();
            preparedStatement.setObject(i, value);
            i++;
        }
        preparedStatement.setString(i, code);
        int nbUpdatedLines = preparedStatement.executeUpdate();
        return (nbUpdatedLines != 0);
    }
}
