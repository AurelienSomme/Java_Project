package DataAccess;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AffairDataAccess {
    ArrayList<Integer> getAllIdsAffairs() throws SQLException;
}
