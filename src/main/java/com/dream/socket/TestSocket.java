package com.dream.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.Vector;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-11-26 下午5:16
 **/
public class TestSocket extends AbstractWebSocketHandler {
    @Autowired
    private Container container;


    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Vector<WebSocketSession> vectors = container.getSessions();
        for(WebSocketSession session1 : vectors){
            session1.sendMessage(message);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        container.addSocketSession(session);
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        container.removeSocketSession(session);
    }


}
