package be.ansur.chat.controller;

import be.ansur.chat.data.Input;
import be.ansur.chat.data.Message;
import be.ansur.chat.data.Room;
import be.ansur.chat.form.*;
import be.ansur.chat.session.UserSession;
import org.apache.commons.collections.buffer.CircularFifoBuffer;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


/**
 * Created by IntelliJ IDEA.
 * User: jo
 * Date: 28/11/11
 * Time: 21:00
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ChatController {

    private static Map<String, Room> rooms = new HashMap<String, Room>();


    @RequestMapping("/chat/createroom")
    @ResponseBody
    public Room createRoom(Input input) {
        String key = null;
        while (key == null || rooms.containsKey(key)) {
            key = UUID.randomUUID().toString();
        }

     /*   if (StringUtils.isEmpty(userSession.getName())) {
            Errors errors = new Errors();
            errors.addError(new be.ansur.chat.form.Error(ErrorCode.NO_USER,"no user, login first"));
            return errors;
        }
        */
        Room room = new Room();
        room.setId(key);
        rooms.put(key, room);
        return room;
    }


    @RequestMapping("/chat/login")
    @ResponseBody
    public Object login(@RequestBody  Input input) {
      return "ok";
    }


    @RequestMapping("/chat/sampleinput")
    @ResponseBody
    public Input sample() {
        Input in = new Input();
        in.setMessage("mess");
        in.setRoomId("roomid");
        in.setUserId("jo");
        return in;
    }

    @RequestMapping("/chat/getmessages")
    @ResponseBody
    public Room getMessages(@RequestBody Input input) {
        return rooms.get(input.getRoomId());
    }

    @RequestMapping("/chat/addmessage")
    @ResponseBody
    public Room addMessage(@RequestBody Input input) {
        Room room =  rooms.get(input.getRoomId());
        CircularFifoBuffer s = room.getStack();
        if (s == null) {
            s = new CircularFifoBuffer(20);
            room.setStack(s);
        }
        Message m = new Message();
        m.setTime(new Date());
        m.setMessage(input.getMessage());
        m.setUserid(input.getUserId());
        s.add(m);
        return room;
    }

}
