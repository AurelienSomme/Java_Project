package Model;

import java.time.LocalDate;

public class Brand {
    private int idBrand;
    private String name;
    private String CEO;
    private LocalDate creationDate;
    private String description;

    public Brand(int idBrand, String name, String CEO, LocalDate creationDate){
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

    public LocalDate getCreationDate(){return creationDate;}

    public String getDescription(){return description;}
}
