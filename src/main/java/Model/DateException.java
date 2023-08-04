package Model;

import java.util.GregorianCalendar;

public class DateException extends Exception{
    private GregorianCalendar wrongDate;
    private String type;

    public DateException(GregorianCalendar date, String type){
        wrongDate = date;
        this.type = type;
    }

    @Override
    public String getMessage() {
        return type + " must be future date (refused : " + wrongDate + ")";
    }
}
