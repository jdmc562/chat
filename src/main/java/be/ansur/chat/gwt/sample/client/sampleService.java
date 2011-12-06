package be.ansur.chat.gwt.sample.client;

import be.ansur.chat.gwt.sample.data.Message;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("sampleService")
public interface sampleService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);


    Message[] addMessage(String msg, String user);

    Message[] getMessages(String text);


    /**
     * Utility/Convenience class.
     * Use sampleService.App.getInstance() to access static instance of sampleServiceAsync
     */
    public static class App {
        private static sampleServiceAsync ourInstance = GWT.create(sampleService.class);

        public static synchronized sampleServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
