package Model;

public class AddIntException  extends Exception{

    private String numberError;
    private String type;

    public AddIntException(String number, String type){
        numberError = number;
        this.type = type;
    }

    public String getMessage(){
        return type + "must be an integer (refused : "+ numberError + ")";
    }

}
