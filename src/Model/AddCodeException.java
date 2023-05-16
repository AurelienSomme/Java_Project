package Model;

public class AddCodeException extends Exception{
    private String codeError;

    public AddCodeException(String code){
        codeError = code;
    }

    public String getMessage(){
        return "Code must be unique (refused : " + codeError + " )";
    }
}
