package be.ansur.chat.form;

/**
 * Created by IntelliJ IDEA.
 * User: jo
 * Date: 28/11/11
 * Time: 21:36
 * To change this template use File | Settings | File Templates.
 */
public class Error {
    private ErrorCode code;
    private String message;

    public   Error(ErrorCode e
    ,String message) {
        this.code= e;
        this.message = message;
    }
    
    public ErrorCode getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

}
