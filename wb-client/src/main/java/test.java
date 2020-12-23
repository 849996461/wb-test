import handler.MyWebSocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

@Slf4j
public class test {
    public static void main(String[] args) throws Exception {

        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new StringMessageConverter());

        String url = "ws://127.0.0.1:8081/chen";
        StompSessionHandler sessionHandler = new MyWebSocketHandler();
        ListenableFuture<StompSession> future = stompClient.connect(url, sessionHandler);

        StompSession session = future.get();
        session.subscribe("/sub", new StompFrameHandler() {
            @Override
            public Type getPayloadType(StompHeaders headers) {
                return String.class;
            }

            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                log.info("客户端接收到消息 = {}", payload);
            }
        });
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
