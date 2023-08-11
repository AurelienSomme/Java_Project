package DataAccess;

import Model.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;

public interface QueryDataAccess {
    ArrayList<PromoItemBrand> getPromosItemBrand(int refBrand) throws SQLException;
    ArrayList<AffairDetail> getAffairDetails(int idAffair) throws SQLException;
    ArrayList<ExpiredBatch> getExpiredBatches(LocalDate date) throws SQLException;
    ArrayList<LeastSoldItem> getLeastSoldItems(int nbItems, int nbMonths) throws SQLException;
    ArrayList<PromoHistory> getPromoHistories(String code) throws SQLException;
    boolean updatePromo(BigDecimal percentRate, LocalDate endDate, String code) throws SQLException;
}
