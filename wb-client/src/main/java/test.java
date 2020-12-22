import handler.MyWebSocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Slf4j
public class test {
    public static void main(String[] args) throws Exception {

        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new StringMessageConverter());

        String url = "ws://127.0.0.1:8081/chen";
        StompSessionHandler sessionHandler = new MyWebSocketHandler();
        ListenableFuture<StompSession> session = stompClient.connect(url, sessionHandler);

        StompSession.Receiptable re = session.get().send("/app/greeting", "abcde");
        log.info("{}", re.getReceiptId());
        while (true) {

        }
    }
}
