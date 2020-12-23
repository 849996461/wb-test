package handler;

import jdk.internal.jline.internal.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

@Slf4j
public class MyWebSocketHandler extends StompSessionHandlerAdapter {

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        log.error("", exception);
        super.handleException(session, command, headers, payload, exception);
    }
}