package Model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.GregorianCalendar;

public class PromoItemBrand {

    private String name;
    private BigDecimal catalogPrice;
    private BigDecimal percent_rate;
    private GregorianCalendar start_date;
    private GregorianCalendar end_date;


    public PromoItemBrand(String name, BigDecimal catalogPrice, BigDecimal percent_rate, GregorianCalendar start_date, GregorianCalendar end_date){
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
    public GregorianCalendar getStart_date() {return start_date;}
    public GregorianCalendar getEnd_date(){ return end_date;}
}
