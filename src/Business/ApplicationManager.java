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

    private String[] nameColumn = {"Code", "Ref brand", "Name", "Catalog price", "Packaging", "VAT","Stock quantity", "Threshold", "Automatic order", "On-sale date", "Reduction points", "Production date"};

    public ApplicationManager() throws SQLException {
        setDao();
    }

    public void setDao() throws SQLException {
        setItemDao(new ItemDBAccess());
        setBrandDao(new BrandDBAccess());
        setAffairDao(new AffairDBAccess());
        setQueryDao(new QueryDBAccess());
    }

    //Setter

    public void setItemDao(ItemDataAccess dao){
        this.itemDao = dao;
    }

    public void setBrandDao(BrandDataAccess dao){ this.brandDao = dao;}

    public void setAffairDao(AffairDataAccess dao){ this.affairDao = dao;}

    public void setQueryDao(QueryDataAccess dao){ this.queryDao = dao;}



    //Item

    public Item getItem(String code) throws SQLException {
        Item item = itemDao.getItem(code);

        return item;
    }

    public Object[][] getAllItems() throws SQLException {
        ArrayList<Item> items = itemDao.getAllItems();

        Object[][] itemsObjectTab;

        itemsObjectTab = new Object[items.size()][nameColumn.length];

        for(int i = 0; i < items.size(); i++){

            itemsObjectTab[i][0] = items.get(i).getCode();
            itemsObjectTab[i][1] = items.get(i).getRefBrand();
            itemsObjectTab[i][2] = items.get(i).getName();
            itemsObjectTab[i][3] = items.get(i).getCatalogPrice();
            itemsObjectTab[i][4] = items.get(i).getPackaging();
            itemsObjectTab[i][5] = items.get(i).getVAT();
            itemsObjectTab[i][6] = items.get(i).getStockQuantity();
            itemsObjectTab[i][7] = items.get(i).getThresholdLimit();
            itemsObjectTab[i][8] = items.get(i).getAutomaticOrder();
            itemsObjectTab[i][9] = items.get(i).getSaleDate().getTime().toGMTString();;
            if(items.get(i).getReductionPoints() != null)
                itemsObjectTab[i][10] = items.get(i).getReductionPoints();
            if(items.get(i).getProductionDate() != null)
                itemsObjectTab[i][11] = items.get(i).getProductionDate().getTime().toGMTString();
        }

        return itemsObjectTab;
    }

    public boolean addItem(Item item) throws SQLException {
        boolean isAdded = itemDao.addItem(item);

        return isAdded;
    }

    public boolean deleteItem(String code) throws SQLException {
        boolean isDeleted = itemDao.deleteItem(code);

        return isDeleted;
    }
    public Boolean updateItem(String code, Map<String, Object> updateValues) throws SQLException {
        boolean isUpdated = itemDao.updateItem(code, updateValues);

        return isUpdated;
    }



    //Brand

    public ArrayList<Integer> getAllIdsBrands() throws SQLException {
        ArrayList<Integer> idsBrands = brandDao.getAllIdsBrands();

        return idsBrands;
    }



    //Affair

    public ArrayList<Integer> getAllIdsAffairs() throws SQLException {
        ArrayList<Integer> idsAffairs = affairDao.getAllIdsAffairs();

        return idsAffairs;
    }



    //Query

    public ArrayList<PromoItemBrand> getPromosItemBrand(int refBrand) throws SQLException {
        ArrayList<PromoItemBrand> promosItemBrand = queryDao.getPromosItemBrand(refBrand);

        return promosItemBrand;
    }

    public ArrayList<AffairDetail> getAffairDetails(int idAffair) throws SQLException{
        ArrayList<AffairDetail> affairDetails = queryDao.getAffairDetails(idAffair);

        return affairDetails;
    }

    public ArrayList<ExpiredBatch> getExpiredBatches(GregorianCalendar date) throws SQLException{
        ArrayList<ExpiredBatch> expiredBatches = queryDao.getExpiredBatches(date);

        return expiredBatches;
    }

    public ArrayList<LeastSoldItem> getLeastSoldItems(int nbItems, int nbMonths) throws SQLException{
        ArrayList<LeastSoldItem> leastSoldItems = queryDao.getLeastSoldItems(nbItems, nbMonths);

        return leastSoldItems;
    }

    public ArrayList<PromoHistory> getPromoHistories(String code) throws SQLException{
        ArrayList<PromoHistory> promoHistories = queryDao.getPromoHistories(code);

        return promoHistories;
    }

    public boolean updatePromo(BigDecimal percentRate, GregorianCalendar endDate, String code) throws SQLException{
        boolean isUpdated = queryDao.updatePromo(percentRate, endDate, code);

        return isUpdated;
    }
}
