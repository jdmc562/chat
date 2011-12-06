package be.ansur.chat.gwt.sample.server;

import be.ansur.chat.gwt.sample.data.Message;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import be.ansur.chat.gwt.sample.client.sampleService;
import org.apache.commons.collections.buffer.CircularFifoBuffer;

import java.util.Date;

public class sampleServiceImpl extends RemoteServiceServlet implements sampleService {
    
    CircularFifoBuffer messages = new CircularFifoBuffer(20);
            
    
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }

    @Override
    public Message[] addMessage(String msg, String user) {
        Message mess = new Message();
        mess.setMessage(msg);
        mess.setTime(new Date());
        mess.setUserid(user);
        messages.add(mess);

        return (Message[]) messages.toArray(new Message[messages.size()]);
    }

    @Override
    public Message[] getMessages(String text) {
        return (Message[]) messages.toArray(new Message[messages.size()]);
    }
}