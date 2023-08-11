package Model;

import java.time.LocalDate;

public class ExpiredBatch {
    private String itemName;
    private String code;
    private int quantity;
    private LocalDate date;
    private LocalDate deliveryDate;
    private String actorName;

    public ExpiredBatch(String itemName, String code, int quantity, LocalDate date, String actorName){
        this.itemName = itemName;
        this.code = code;
        this.quantity = quantity;
        this.date = date;
        this.deliveryDate = null;
        this.actorName = actorName;
    }

    public void setDeliveryDate(LocalDate deliveryDate){
        this.deliveryDate =  deliveryDate;
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

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public String getActorName() {
        return actorName;
    }
}
