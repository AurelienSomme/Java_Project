package DataAccess;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BrandDataAccess {

    ArrayList<Integer> getAllIdsBrands() throws SQLException;
}
