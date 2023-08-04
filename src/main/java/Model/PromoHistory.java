package Model;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class PromoHistory {
    private int code;
    private BigDecimal percentRate;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;

    public PromoHistory(int code, BigDecimal percentRate, GregorianCalendar startDate, GregorianCalendar endDate) {
        this.code = code;
        this.percentRate = percentRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getCode() {
        return code;
    }

    public BigDecimal getPercentRate() {
        return percentRate;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }
}
