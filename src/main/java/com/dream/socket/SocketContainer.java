package com.dream.socket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Vector;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-11-27 下午3:43
 **/
@Component
public class SocketContainer {
	Vector<WebSocketSession> vectors = new Vector<>();

	public synchronized void addSocketSession(WebSocketSession webSocketSession) {
		vectors.add(webSocketSession);
	}

	public synchronized Vector getSessions() {
		return vectors;
	}

	public synchronized void removeSocketSession(WebSocketSession webSocketSession) {
		vectors.remove(webSocketSession);
	}


}
