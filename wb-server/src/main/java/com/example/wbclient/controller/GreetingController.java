package com.example.wbclient.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.util.Calendar;

@Controller
@Slf4j
public class GreetingController {

    @MessageMapping("/greeting")
    public String handle(String greeting) {
        String res = "[" + Calendar.getInstance().toInstant() + ": " + greeting;
        log.info("{}", res);
        return res;
    }
}