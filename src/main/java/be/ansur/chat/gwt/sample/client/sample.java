package be.ansur.chat.gwt.sample.client;

import be.ansur.chat.gwt.sample.data.Message;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import java.util.Date;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class sample implements EntryPoint {

    final Button button = new Button("Send");
    Date lastSent = null;
    final TextBox user = new TextBox();

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final Label label = new Label();
        final TextArea input = new TextArea();
        input.setCharacterWidth(30);
        input.setVisibleLines(3);
        final TextBox output = new TextBox();
        final FlexTable table = new FlexTable();


        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                  sampleService.App.getInstance().addMessage(input.getText(), user.getText(), new MyAsyncCallback(output, table));
                input.setText("");
                lastSent=new Date();
            }
        });

        SubmitListener sl = new SubmitListener();
        input.addKeyboardListener(sl);


        Timer timer = new Timer() {
            @Override
            public void run() {
                sampleService.App.getInstance().getMessages(user.getText(), new MyAsyncCallback(output, table));
            }
        } ;

        timer.scheduleRepeating(10000);
        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("button").add(button);
        RootPanel.get("input").add(input);
        RootPanel.get("user").add(user);
        RootPanel.get("table").add(table);


    }


    private class SubmitListener extends KeyboardListenerAdapter {
        public void onKeyPress(Widget sender, char key, int mods) {
            if (KeyboardListener.KEY_ENTER == key)
                button.click();
        }
    }


private class MyAsyncCallback implements AsyncCallback<Message[]> {

    TextBox output;
    private FlexTable table;
    DateTimeFormat format;

    public MyAsyncCallback(TextBox output, FlexTable table) {
        this.output = output;
        this.table = table;

        format = DateTimeFormat.getFormat("EEE HH:mm:ss");
    }

    @Override
    public void onFailure(Throwable caught) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onSuccess(Message[] result) {
        output.setText(""+result.length);
        table.removeAllRows();
        int row=0;
        for (int i=result.length-1; i >= 0; i--) {
              table.setText(row,0,format.format(result[i].getTime()));
            table.setText(row,1,result[i].getUserid());
            table.setText(row,2,result[i].getMessage());
            if (!user.getText().equals (result[i].getUserid()) && ( lastSent == null || lastSent.before(result[i].getTime()))) {
                table.getFlexCellFormatter().setStyleName(row,1,"red");
            } else {
                table.getFlexCellFormatter().setStyleName(row,1,"black");
            }
            row++;
        }
    }
}
}
