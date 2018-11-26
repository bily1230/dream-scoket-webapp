package spring;

import com.dream.socket.TestSocket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-11-26 下午5:21
 **/
@Configuration
@EnableWebSocket
public class SocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(testSocket(), "/testSocket");
    }

    @Bean
    public TestSocket testSocket() {
        return new TestSocket();
    }
}
