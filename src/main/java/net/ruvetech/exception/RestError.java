package net.ruvetech.exception;

public class RestError {

    private String code;
    private String message;

    public RestError() {
    }

    public RestError(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
