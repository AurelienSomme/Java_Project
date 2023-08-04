package Model;

import java.math.BigDecimal;

public class AffairDetail {
    private String brandName;
    private String itemName;
    private int quantity;
    private BigDecimal price;

    public AffairDetail(String brandName, String itemName, int quantity, BigDecimal price){
        this.brandName = brandName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBrandName(){return brandName;}
    public String getItemName() {return itemName;}
    public int getQuantity() {return quantity;}
    public BigDecimal getPrice() {return price;}
}
