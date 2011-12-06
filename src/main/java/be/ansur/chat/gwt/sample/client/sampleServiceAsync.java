package be.ansur.chat.gwt.sample.client;

import be.ansur.chat.gwt.sample.data.Message;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface sampleServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);

    void addMessage(String msg, String user, AsyncCallback<Message[]> async);

    void getMessages(String text, AsyncCallback<Message[]> async);
}
