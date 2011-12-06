package be.ansur.chat.data;

/**
 * Created by IntelliJ IDEA.
 * User: jo
 * Date: 06/12/11
 * Time: 19:15
 * To change this template use File | Settings | File Templates.
 */
public class Input {
    private String userId;
    private String roomId;
    private String message;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
