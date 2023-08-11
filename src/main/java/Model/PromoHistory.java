package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PromoHistory {
    private int code;
    private BigDecimal percentRate;
    private LocalDate startDate;
    private LocalDate endDate;

    public PromoHistory(int code, BigDecimal percentRate, LocalDate startDate, LocalDate endDate) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
