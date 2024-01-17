package kiloit.demo.security.exeception.exception;


import lombok.Getter;

public class BadResqestException extends RuntimeException {

    private final String message;
    @Getter
    private Object data;
    public BadResqestException(String message, String messageKey, Object data) { //constructer
        this.message = message;
        this.data = data;
    }
    //Overide costructor
    public BadResqestException(String message){this.message =message;}
    @Override
    public String getMessage(){
        return message;
    }
}
