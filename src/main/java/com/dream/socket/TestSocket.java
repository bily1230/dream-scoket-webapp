package com.dream.socket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-11-26 下午5:16
 **/
public class TestSocket  extends AbstractWebSocketHandler {
    List<WebSocketSession> list = new ArrayList<>();
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        System.out.println(message);
        list.add(session);
        for(WebSocketSession session1 : list){
            session1.sendMessage(new TextMessage("Polo!"));
        }

    }

}
