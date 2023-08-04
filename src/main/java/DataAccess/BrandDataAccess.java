package DataAccess;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BrandDataAccess {

    ArrayList<String> getAllIdsBrands() throws SQLException;
}
