package DataAccess;

import Model.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;

public class QueryDBAccess implements QueryDataAccess{

    private Connection connection;

    public QueryDBAccess(){
        connection = SingletonConnection.getInstance();
    }

    public ArrayList<PromoItemBrand> getPromosItemBrand(int refBrand) throws SQLException {
        ArrayList<PromoItemBrand> promosItemBrand = new ArrayList<>();

        String instructionQuery = "SELECT i.name, i.catalog_price, p.percent_rate, pd.start_date, pd.end_date\n" +
                "FROM item i\n" +
                "INNER JOIN brand b ON i.ref_brand = b.id_brand\n" +
                "INNER JOIN promotion_date pd ON pd.ref_item = i.code\n" +
                "INNER JOIN promotion p ON pd.ref_promotion = p.code\n" +
                "WHERE b.id_brand = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(instructionQuery);
        preparedStatement.setInt(1, refBrand);
        ResultSet data = preparedStatement.executeQuery();

        PromoItemBrand promoItemBrand;
        while (data.next()) {
            LocalDate startDate = data.getDate("start_date").toLocalDate();
            LocalDate endDate = data.getDate("end_date").toLocalDate();
            promoItemBrand = new PromoItemBrand(data.getString("name"), data.getBigDecimal("catalog_price")
                                                , data.getBigDecimal("percent_rate"), startDate, endDate);
            promosItemBrand.add(promoItemBrand);
        }
        return promosItemBrand;
    }

    @Override
    public ArrayList<AffairDetail> getAffairDetails(int idAffair) throws SQLException {
        ArrayList<AffairDetail> affairDetails = new ArrayList<>();

        String instructionQuery = "SELECT b.name AS brand_name, i.name AS item_name, d.quantity, ROUND(d.real_price * (1 + d.VAT/100), 2) AS price\n" +
                "FROM detail_affair d\n" +
                "JOIN affair a ON d.ref_affair = a.id_affair\n" +
                "JOIN item i ON d.ref_item = i.code\n" +
                "JOIN brand b ON i.ref_brand = b.id_brand\n" +
                "WHERE a.id_affair = ?\n" +
                "ORDER BY item_name ASC;";

        PreparedStatement preparedStatement = connection.prepareStatement(instructionQuery);
        preparedStatement.setInt(1, idAffair);
        ResultSet data = preparedStatement.executeQuery();

        AffairDetail affairDetail;
        while (data.next()){
            affairDetail = new AffairDetail(data.getString("brand_name"), data.getString("item_name"),
                                                data.getInt("quantity"), data.getBigDecimal("price"));

            affairDetails.add(affairDetail);
        }


        return affairDetails;
    }

    public ArrayList<ExpiredBatch> getExpiredBatches(LocalDate date) throws SQLException{
        ArrayList<ExpiredBatch> expiredBatches = new ArrayList<>();

        String instructionQuery = "SELECT i.name, b.code, da.quantity, a.date_affair, a.delivery_date, ac.name\n" +
                "FROM batch b\n" +
                "INNER JOIN detail_affair da ON b.ref_affair = da.ref_affair AND b.ref_item = da.ref_item\n" +
                "INNER JOIN affair a ON da.ref_affair = a.id_affair\n" +
                "INNER JOIN item i ON b.ref_item = i.code\n" +
                "INNER JOIN actor ac ON a.ref_actor = ac.num\n" +
                "WHERE b.expiration_date < DATE ?\n" +
                "ORDER BY a.date_affair DESC;";

        PreparedStatement preparedStatement = connection.prepareStatement(instructionQuery);
        preparedStatement.setDate(1, java.sql.Date.valueOf(date));
        ResultSet data = preparedStatement.executeQuery();

        ExpiredBatch expiredBatch;
        while (data.next()){

            LocalDate dateData = data.getDate("date_affair").toLocalDate();
            LocalDate deliveryDate = data.getDate("delivery_date").toLocalDate();

            expiredBatch = new ExpiredBatch(data.getString("i.name"), data.getString("code"),
                    data.getInt("quantity"), dateData, deliveryDate, data.getString("ac.name"));

            expiredBatches.add(expiredBatch);
        }
        return expiredBatches;
    }

    public ArrayList<LeastSoldItem> getLeastSoldItems(int nbItems, int nbMonths) throws SQLException{
        ArrayList<LeastSoldItem> leastSoldItems = new ArrayList<>();
        String instructionQuery = "SELECT\n" +
                "    i.code as code_item,\n" +
                "    i.name AS name_item,\n" +
                "    i.catalog_price AS price,\n" +
                "    COUNT(da.ref_item) AS nb_sales,\n" +
                "    CASE\n" +
                "        WHEN pd.start_date <= CURDATE() AND pd.end_date >= CURDATE() THEN true\n" +
                "        ELSE false\n" +
                "        END AS is_in_promo\n" +
                "FROM\n" +
                "    item i\n" +
                "        LEFT JOIN\n" +
                "    detail_affair da ON i.code = da.ref_item\n" +
                "        LEFT JOIN\n" +
                "    affair a ON da.ref_affair = a.id_affair\n" +
                "        LEFT JOIN\n" +
                "    promotion_date pd ON i.code = pd.ref_item\n" +
                "WHERE\n" +
                "        a.date_affair >= DATE_SUB(CURDATE(), INTERVAL ? MONTH)\n" +
                "GROUP BY\n" +
                "    i.code\n" +
                "ORDER BY\n" +
                "    nb_sales ASC\n" +
                "LIMIT ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(instructionQuery);
        preparedStatement.setInt(1, nbMonths);
        preparedStatement.setInt(2, nbItems);
        ResultSet data = preparedStatement.executeQuery();

        LeastSoldItem leastSoldItem;
        while (data.next()){
            leastSoldItem = new LeastSoldItem(data.getString("code_item"), data.getString("name_item"),
                                               data.getBigDecimal("price"), data.getInt("nb_sales"), data.getBoolean("is_in_promo"));
            leastSoldItems.add(leastSoldItem);
        }
        return leastSoldItems;
    }

    public ArrayList<PromoHistory> getPromoHistories(String code) throws SQLException{
        ArrayList<PromoHistory> promoHistories = new ArrayList<>();

        String instructionQuery = "SELECT promotion.code, promotion.percent_rate, promotion_date.start_date, promotion_date.end_date\n" +
                "FROM promotion\n" +
                "         INNER JOIN promotion_date ON promotion.code = promotion_date.ref_promotion\n" +
                "WHERE promotion_date.ref_item = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(instructionQuery);
        preparedStatement.setString(1, code);
        ResultSet data = preparedStatement.executeQuery();

        PromoHistory promoHistory;
        while (data.next()){
            LocalDate startDate = data.getDate("promotion_date.start_date").toLocalDate();
            LocalDate endDate = data.getDate("promotion_date.end_date").toLocalDate();

            promoHistory = new PromoHistory(data.getInt("promotion.code"), data.getBigDecimal("promotion.percent_rate"), startDate, endDate);
            promoHistories.add(promoHistory);
        }

        return promoHistories;
    }

    public boolean updatePromo(BigDecimal percentRate, LocalDate endDate, String code) throws SQLException {

        String instructionQuery = "UPDATE promotion_date\n" +
                "SET end_date = CURRENT_DATE\n" +
                "WHERE ref_item = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(instructionQuery);
        preparedStatement.setString(1, code);
        preparedStatement.executeUpdate();

        String instructionQueryAny =
                                "SELECT *\n" +
                                "FROM promotion\n" +
                                "WHERE percent_rate = ?;";

        PreparedStatement preparedStatementAny = connection.prepareStatement(instructionQueryAny);
        preparedStatementAny.setBigDecimal(1, percentRate);


        ResultSet data = preparedStatementAny.executeQuery();

        if(data.next()){
            int codePromo = data.getInt("code");
            String instructionQueryUpdate = "INSERT INTO promotion_date (start_date, end_date, ref_promotion, ref_item)\n" +
                    "VALUES (CURRENT_DATE, ?, ?, ?)\n;";

            PreparedStatement preparedStatementUpdate = connection.prepareStatement(instructionQueryUpdate);
            preparedStatementUpdate.setDate(1, java.sql.Date.valueOf(endDate));
            preparedStatementUpdate.setInt(2, codePromo);
            preparedStatementUpdate.setString(3, code);

            int nbUpdatedLines = preparedStatementUpdate.executeUpdate();
            return nbUpdatedLines > 0;
        }
        else {

            String instructionGetPromoId = "select code from promotion";
            PreparedStatement preparedStatementCodes = connection.prepareStatement(instructionGetPromoId);
            ResultSet dataCodes = preparedStatementCodes.executeQuery();
            int newCode = 0;
            while(dataCodes.next()){
                newCode = dataCodes.getInt("code");
            }
            newCode++;

            String instructionInsertPromo =
                    "INSERT INTO promotion (code, percent_rate)\n" +
                    "VALUES (?, ?);\n";

            String instructionInsertPromoDate = "INSERT INTO promotion_date (start_date, end_date, ref_promotion, ref_item)\n" +
                    "VALUES (CURRENT_DATE, ?, ?, ?);\n";


            PreparedStatement preparedStatementPromo = connection.prepareStatement(instructionInsertPromo);
            preparedStatementPromo.setInt(1, newCode);
            preparedStatementPromo.setBigDecimal(2, percentRate);
            preparedStatementPromo.execute();

            PreparedStatement preparedStatementPromoDate = connection.prepareStatement(instructionInsertPromoDate);
            preparedStatementPromoDate.setDate(1, java.sql.Date.valueOf(endDate));
            preparedStatementPromoDate.setInt(2, newCode);
            preparedStatementPromoDate.setString(3, code);
            preparedStatementPromoDate.execute();
            return true;
        }
    }
}
