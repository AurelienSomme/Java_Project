package Controller;

import DataAccess.ItemDBAccess;
import DataAccess.ItemDataAccess;
import Model.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class ApplicationController {

    private ItemDataAccess dao;

    public ApplicationController() throws SQLException {
        setDao(new ItemDBAccess());
    }

    public void setDao(ItemDataAccess dao){
        this.dao = dao;
    }


    public Item getItem(String code) throws SQLException {
        return dao.getItem(code);
    }

    public ArrayList<Item> getAllItems() throws SQLException {
        return dao.getAllItems();
    }

    public boolean addItem(Item item) throws SQLException {
        return dao.addItem(item);
    }

    public boolean deleteItem(String code) throws SQLException {
        return dao.deleteItem(code);
    }
    public Boolean updateItem(int code, Map<String, Object> updateValues) throws SQLException {
        return dao.updateItem(code, updateValues);
    }
}
