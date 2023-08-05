package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PromoItemBrand {

    private String name;
    private BigDecimal catalogPrice;
    private BigDecimal percent_rate;
    private LocalDate start_date;
    private LocalDate end_date;


    public PromoItemBrand(String name, BigDecimal catalogPrice, BigDecimal percent_rate, LocalDate start_date, LocalDate end_date){
        this.name = name;
        this.catalogPrice = catalogPrice;
        this.percent_rate = percent_rate;
        this.start_date = start_date;
        this.end_date = end_date;
    }



    public String getName(){
        return name;
    }
    public BigDecimal getCatalogPrice(){
        return catalogPrice;
    }
    public BigDecimal getPercent_rate() { return percent_rate;}
    public LocalDate getStart_date() {return start_date;}
    public LocalDate getEnd_date(){ return end_date;}
}
