package Model;

import java.util.GregorianCalendar;

public class ExpiredBatch {
    private String itemName;
    private String code;
    private int quantity;
    private GregorianCalendar date;
    private GregorianCalendar deliveryDate;
    private String actorName;

    public ExpiredBatch(String itemName, String code, int quantity, GregorianCalendar date, GregorianCalendar deliveryDate, String actorName){
        this.itemName = itemName;
        this.code = code;
        this.quantity = quantity;
        this.date = date;
        this.deliveryDate = deliveryDate;
        this.actorName = actorName;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public GregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    public String getActorName() {
        return actorName;
    }
}
