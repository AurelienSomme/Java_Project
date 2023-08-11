package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Item {
    private String code;
    private int refBrand;
    private String name;
    private BigDecimal catalogPrice;
    private BigDecimal reductionPoints;
    private String packaging;
    private BigDecimal VAT;
    private BigDecimal stockQuantity;
    private BigDecimal thresholdLimit;
    private boolean automaticOrder;
    private LocalDate productionDate;
    private LocalDate saleDate;



    public Item(String code, int refBrand, String name, BigDecimal catalogPrice, String packaging, BigDecimal VAT, BigDecimal stockQuantity, BigDecimal thresholdLimit, boolean automaticOrder, LocalDate saleDate){
        this.code = code;
        this.refBrand = refBrand;
        this.name = name;
        this.catalogPrice = catalogPrice;
        this.packaging = packaging;
        this.VAT = VAT;
        this.stockQuantity = stockQuantity;
        this.thresholdLimit = thresholdLimit;
        this.automaticOrder = automaticOrder;
        this.saleDate = saleDate;
        this.reductionPoints = null;
        this.productionDate = null;
    }



    public String getCode(){
        return code;
    }
    public int getRefBrand(){
        return refBrand;
    }
    public String getName(){
        return name;
    }
    public BigDecimal getCatalogPrice(){
        return catalogPrice;
    }
    public String getPackaging(){
        return packaging;
    }
    public BigDecimal getVAT(){
        return VAT;
    }
    public BigDecimal getStockQuantity(){
        return stockQuantity;
    }
    public BigDecimal getThresholdLimit(){
        return thresholdLimit;
    }
    public boolean getAutomaticOrder(){
        return automaticOrder;
    }
    public LocalDate getSaleDate(){
        return saleDate;
    }
    public LocalDate getProductionDate(){
        return productionDate;
    }
    public BigDecimal getReductionPoints(){ return reductionPoints;}

    public void setReductionPoints(BigDecimal reductionPoints) {
        this.reductionPoints = reductionPoints;
    }

    public void setProductionDate(LocalDate productionDate){
        this.productionDate = productionDate;
    }



    public String toString(){
        return code + " " + refBrand + " " + name + " " + catalogPrice + " " + packaging + " " + VAT  + " " + stockQuantity + " " + thresholdLimit + " " + automaticOrder  + " " + saleDate + " " + productionDate  + " " + reductionPoints;
    }
}
