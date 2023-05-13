package Controller;

import DataAccess.*;
import Model.Brand;
import Model.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class ApplicationController {

    private ItemDataAccess itemDao;
    private BrandDataAccess brandDao;
    private AffairDataAccess affairDao;

    public ApplicationController() throws SQLException {
        setItemDao(new ItemDBAccess());
        setBrandDao(new BrandDBAccess());
        setAffairDao(new AffairDBAccess());
    }

    public void setItemDao(ItemDataAccess dao){
        this.itemDao = dao;
    }

    public void setBrandDao(BrandDataAccess dao){ this.brandDao = dao;}

    public void setAffairDao(AffairDataAccess dao){ this.affairDao = dao;}


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
    public Boolean updateItem(int code, Map<String, Object> updateValues) throws SQLException {
        return itemDao.updateItem(code, updateValues);
    }

    public ArrayList<Integer> getAllIdsBrands() throws SQLException {
        return brandDao.getAllIdsBrands();
    }

    public ArrayList<Integer> getAllIdsAffairs() throws SQLException {
        return affairDao.getAllIdsAffairs();
    }
}
