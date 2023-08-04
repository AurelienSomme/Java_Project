package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AffairDBAccess implements AffairDataAccess{

    private Connection connection;

    public AffairDBAccess(){
        connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Integer> getAllIdsAffairs() throws SQLException {
        ArrayList<Integer> idsAffairs = new ArrayList<>();
        String allIdsInstruction = "SELECT id_affair from affair;";
        PreparedStatement preparedStatement = connection.prepareStatement(allIdsInstruction);
        ResultSet data = preparedStatement.executeQuery();

        while (data.next()){
            idsAffairs.add(data.getInt("id_affair"));
        }

        return idsAffairs;
    }
}
