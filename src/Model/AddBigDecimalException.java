package Model;

public class AddBigDecimalException extends Exception{
    private String bigDecimalError;
    private String type;

    public AddBigDecimalException(String bigDecimal , String type){
        bigDecimalError = bigDecimal;
        this.type = type;
    }

    @Override
    public String getMessage() {
        return type + " must be a float/integer (refused : " + bigDecimalError + ")";
    }
}

