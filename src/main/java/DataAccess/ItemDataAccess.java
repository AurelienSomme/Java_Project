package DataAccess;

import Model.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface  ItemDataAccess { //throws AddItemException

    Item getItem(String code) throws SQLException;

    ArrayList<Item> getAllItems() throws SQLException;

    boolean addItem(Item item) throws SQLException;

    boolean deleteItem(String code) throws SQLException;

    Boolean updateItem(String code, Map<String, Object> updateValues) throws SQLException;
}
