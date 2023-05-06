package DataAccess;

import Model.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface  ItemDataAccess { //throws AddItemException


    ArrayList<Item> getAllItems() throws SQLException;

    boolean addItem(Item item) throws SQLException;

    boolean deleteItem(String code) throws SQLException;
}
