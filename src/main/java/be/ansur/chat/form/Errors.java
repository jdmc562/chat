package be.ansur.chat.form;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jo
 * Date: 28/11/11
 * Time: 21:29
 * To change this template use File | Settings | File Templates.
 */
public class Errors {
    private List<Error> errors;
    
    public Errors() {
        errors = new ArrayList<Error>();
    }
    
    public void addError(Error s) {
        errors.add(s);
    }
}
