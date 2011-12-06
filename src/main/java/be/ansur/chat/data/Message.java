package be.ansur.chat.data;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: jo
 * Date: 06/12/11
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
public class Message implements Serializable {
    private String message;
    private String userid;
    private Date time;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
