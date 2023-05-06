package Controller;

import DataAccess.ItemDBAccess;
import DataAccess.ItemDataAccess;
import Model.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ApplicationController {

    private ItemDataAccess dao;

    public ApplicationController() throws SQLException {
        setDao(new ItemDBAccess());
    }

    public void setDao(ItemDataAccess dao){
        this.dao = dao;
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
}
