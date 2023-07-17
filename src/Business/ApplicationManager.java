package Business;

import DataAccess.*;
import Model.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;

public class ApplicationManager {

    private ItemDataAccess itemDao;
    private BrandDataAccess brandDao;
    private AffairDataAccess affairDao;
    private QueryDataAccess queryDao;

    public ApplicationManager() throws SQLException {
        setDao();
    }

    public void setDao() throws SQLException {
        setItemDao(new ItemDBAccess());
        setBrandDao(new BrandDBAccess());
        setAffairDao(new AffairDBAccess());
        setQueryDao(new QueryDBAccess());
    }

    public void setItemDao(ItemDataAccess dao){
        this.itemDao = dao;
    }

    public void setBrandDao(BrandDataAccess dao){ this.brandDao = dao;}

    public void setAffairDao(AffairDataAccess dao){ this.affairDao = dao;}

    public void setQueryDao(QueryDataAccess dao){ this.queryDao = dao;}


    public Item getItem(String code) throws SQLException {
        return itemDao.getItem(code);
    }

    public ArrayList<Item> getAllItems() throws SQLException {
        return itemDao.getAllItems();
    }

    public boolean addItem(Item item) throws SQLException {
        return itemDao.addItem(item);
    }

    public boolean deleteItem(String code) throws SQLException {
        return itemDao.deleteItem(code);
    }
    public Boolean updateItem(String code, Map<String, Object> updateValues) throws SQLException {
        return itemDao.updateItem(code, updateValues);
    }



    public ArrayList<Integer> getAllIdsBrands() throws SQLException {
        return brandDao.getAllIdsBrands();
    }



    public ArrayList<Integer> getAllIdsAffairs() throws SQLException {
        return affairDao.getAllIdsAffairs();
    }


    public ArrayList<PromoItemBrand> getPromosItemBrand(int refBrand) throws SQLException {
        return queryDao.getPromosItemBrand(refBrand);
    }

    public ArrayList<AffairDetail> getAffairDetails(int idAffair) throws SQLException{
        return queryDao.getAffairDetails(idAffair);
    }

    public ArrayList<ExpiredBatch> getExpiredBatches(GregorianCalendar date) throws SQLException{
        return queryDao.getExpiredBatches(date);
    }

    public ArrayList<LeastSoldItem> getLeastSoldItems(int nbItems, int nbMonths) throws SQLException{
        return queryDao.getLeastSoldItems(nbItems, nbMonths);
    }

    public ArrayList<PromoHistory> getPromoHistories(String code) throws SQLException{
        return queryDao.getPromoHistories(code);
    }

    public boolean updatePromo(BigDecimal percentRate, GregorianCalendar endDate, String code) throws SQLException{
        return queryDao.updatePromo(percentRate, endDate, code);
    }
}
