package com.dream.socket.message;

import com.dream.socket.AutoRunnable;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-7 下午4:30
 **/
@Component
public class MessageCenter extends AutoRunnable {

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final ArrayBlockingQueue<WebSocketMessage> queue = new ArrayBlockingQueue<>(0xffff);
    private final Vector<WebSocketSession> sessions = new Vector<>();


    public synchronized void addListener(WebSocketSession socketSession) {
        sessions.add(socketSession);
    }

    public synchronized void removeListener(WebSocketSession socketSession) {
        sessions.remove(socketSession);
    }

    @Override
    public void autoRun() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        WebSocketMessage message = queue.take();
                        MessageCenter.this.notifyAll(message);
                    } catch (Exception e) {

                    }
                }
            }
        });
    }


    public void notifyAll(WebSocketMessage message) {
        WebSocketSession[] sessionArr;
        synchronized (sessions){
            sessionArr = sessions.toArray(new WebSocketSession[0]);
        }
      //  Arrays.stream(sessionArr).forEach(s-> this.executorService.execute(new NotifyTask(message, s)));

    }


    class NotifyTask implements Runnable {
        WebSocketMessage message;
        WebSocketSession session;
        NotifyTask(WebSocketMessage message,WebSocketSession session){
            message = message;
            session = session;
        }

        @Override
        public void run() {
            try {
                session.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
