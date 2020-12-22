package com.example.wbclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WbTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WbTestApplication.class, args);
//		List<Transport> transports = new ArrayList<>(2);
//		transports.add(new WebSocketTransport(new StandardWebSocketClient()));
//		transports.add(new RestTemplateXhrTransport());
//
//		SockJsClient sockJsClient = new SockJsClient(transports);
//		sockJsClient.doHandshake(new MyWebSocketHandler(), "ws://localhost:8080/sockjs");
	}

}
