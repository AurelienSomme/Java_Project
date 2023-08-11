package Model;

import java.time.LocalDate;

public class DateException extends Exception{
    private LocalDate wrongDate;
    private String type;

    public DateException(LocalDate date, String type){
        wrongDate = date;
        this.type = type;
    }

    @Override
    public String getMessage() {
        return type + " must be future date (refused : " + wrongDate + ")";
    }
}
