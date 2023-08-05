package Controller;

import Business.ApplicationManager;
import DataAccess.*;
import Model.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class ApplicationController {

    private ApplicationManager applicationManager;



    public ApplicationController() throws SQLException {

    }



    public void setApplicationManager(ApplicationManager applicationManager){
        this.applicationManager = applicationManager;
    }




    public Item getItem(String code) throws SQLException {
        return applicationManager.getItem(code);
    }

    public Object[][] getAllItems() throws SQLException {
        return applicationManager.getAllItems();
    }

    public boolean addItem(Item item) throws SQLException {
        return applicationManager.addItem(item);
    }

    public boolean deleteItem(String code) throws SQLException {
        return applicationManager.deleteItem(code);
    }
    public Boolean updateItem(String code, Map<String, Object> updateValues) throws SQLException {
        return applicationManager.updateItem(code, updateValues);
    }

    public ArrayList<String> getAllIdsBrands() throws SQLException {
        return applicationManager.getAllIdsBrands();
    }

    public ArrayList<Integer> getAllIdsAffairs() throws SQLException {
        return applicationManager.getAllIdsAffairs();
    }

    public Object[][] getPromosItemBrand(int refBrand) throws SQLException {
        return applicationManager.getPromosItemBrand(refBrand);
    }

    public Object[][] getAffairDetails(int idAffair) throws SQLException{
        return applicationManager.getAffairDetails(idAffair);
    }

    public Object[][] getExpiredBatches(LocalDate date) throws SQLException{
        return applicationManager.getExpiredBatches(date);
    }

    public ArrayList<LeastSoldItem> getLeastSoldItems(int nbItems, int nbMonths) throws SQLException{
        return applicationManager.getLeastSoldItems(nbItems, nbMonths);
    }

    public ArrayList<PromoHistory> getPromoHistories(String code) throws SQLException{
        return applicationManager.getPromoHistories(code);
    }

    public boolean updatePromo(BigDecimal percentRate, LocalDate endDate, String code) throws SQLException{
        return applicationManager.updatePromo(percentRate, endDate, code);
    }

    public boolean tryConnectionDB(String password) throws SQLException {
        return SingletonConnection.getInstance(password);
    }
}
