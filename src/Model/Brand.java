package Model;

import java.util.GregorianCalendar;

public class Brand {
    private int idBrand;
    private String name;
    private String CEO;
    private GregorianCalendar creationDate;
    private String description;

    public Brand(int idBrand, String name, String CEO, GregorianCalendar creationDate){
        this.idBrand = idBrand;
        this.name = name;
        this.CEO = CEO;
        this.creationDate = creationDate;
    }

    public Brand(){};

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdBrand(){
        return idBrand;
    }

    public String getName(){return name;}

    public String getCEO(){return CEO;}

    public GregorianCalendar getCreationDate(){return creationDate;}

    public String getDescription(){return description;}
}
