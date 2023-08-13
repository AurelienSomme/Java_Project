package DataAccess;

import Model.Brand;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BrandDataAccess {

    ArrayList<String> getAllIdsBrands() throws SQLException;

    ArrayList<Brand> getAllBrands() throws SQLException;
}
