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

    private String[] nameColumnItem = {"Code", "Ref brand", "Name", "Catalog price", "Packaging", "VAT","Stock quantity", "Threshold", "Automatic order", "On-sale date", "Reduction points", "Production date"};
    private String[] nameColumnPromo = {"Name", "Catalog Price", "Percent Rate", "Start Date", "End Date"};
    private String[] nameColumnExpiredBatches = {"Name Item", "Code", "Quantity", "Date", "Delivery Date", "Name Actor"};
    private String[] nameColumnAffair = {"Brand Name", "Item Name", "Quantity", "Price"};

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

        itemsObjectTab = new Object[items.size()][nameColumnItem.length];

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

    public Object[][] getPromosItemBrand(int refBrand) throws SQLException {
        ArrayList<PromoItemBrand> promosItemBrand = queryDao.getPromosItemBrand(refBrand);

        Object[][] promosItemsBrandObjectTab = new Object[promosItemBrand.size()][nameColumnPromo.length];

        for(int i = 0; i < promosItemBrand.size(); i++) {
            promosItemsBrandObjectTab[i][0] = promosItemBrand.get(i).getName();
            promosItemsBrandObjectTab[i][1] = promosItemBrand.get(i).getCatalogPrice();
            promosItemsBrandObjectTab[i][2] = promosItemBrand.get(i).getPercent_rate();
            promosItemsBrandObjectTab[i][3] = promosItemBrand.get(i).getStart_date().getTime().toString();
            promosItemsBrandObjectTab[i][4] = promosItemBrand.get(i).getEnd_date().getTime().toString();
        }

        return promosItemsBrandObjectTab;
    }

    public Object[][] getAffairDetails(int idAffair) throws SQLException{
        ArrayList<AffairDetail> affairDetails = queryDao.getAffairDetails(idAffair);

        Object[][] affairDetailsObjectTab = new Object[affairDetails.size()][nameColumnAffair.length];

        for (int i = 0; i < affairDetails.size(); i++) {
            affairDetailsObjectTab[i][0] = affairDetails.get(i).getBrandName();
            affairDetailsObjectTab[i][1] = affairDetails.get(i).getItemName();
            affairDetailsObjectTab[i][2] = affairDetails.get(i).getQuantity();
            affairDetailsObjectTab[i][3] = affairDetails.get(i).getPrice();
        }

        return affairDetailsObjectTab;
    }

    public Object[][] getExpiredBatches(GregorianCalendar date) throws SQLException{
        ArrayList<ExpiredBatch> expiredBatches = queryDao.getExpiredBatches(date);

        Object[][] expiredBatchesObjectTab = new Object[expiredBatches.size()][nameColumnExpiredBatches.length];

        for(int i = 0; i < expiredBatches.size(); i++) {
            expiredBatchesObjectTab[i][0] = expiredBatches.get(i).getItemName();
            expiredBatchesObjectTab[i][1] = expiredBatches.get(i).getCode();
            expiredBatchesObjectTab[i][2] = expiredBatches.get(i).getQuantity();
            expiredBatchesObjectTab[i][3] = expiredBatches.get(i).getDate().getTime().toString();
            expiredBatchesObjectTab[i][4] = expiredBatches.get(i).getDeliveryDate().getTime().toString();
            expiredBatchesObjectTab[i][5] = expiredBatches.get(i).getActorName();
        }

        return expiredBatchesObjectTab;
    }



    //Task

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
