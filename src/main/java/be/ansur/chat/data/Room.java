package be.ansur.chat.data;

import org.apache.commons.collections.buffer.CircularFifoBuffer;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: jo
 * Date: 06/12/11
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
public class Room {
    private String id;
    private CircularFifoBuffer stack;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CircularFifoBuffer getStack() {
        return stack;
    }

    public void setStack(CircularFifoBuffer stack) {
        this.stack = stack;
    }
}
