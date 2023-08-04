package Model;

import java.math.BigDecimal;

public class LeastSoldItem {
    private String code;
    private String name;
    private BigDecimal price;
    private int nbSales;
    private boolean isInPromo;

    public LeastSoldItem(String code, String name, BigDecimal price, int nbSales, boolean isInPromo) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.nbSales = nbSales;
        this.isInPromo = isInPromo;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getNbSales() {
        return nbSales;
    }

    public boolean isInPromo() {
        return isInPromo;
    }
}
