package com.example.demo.web;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    private final SimpMessagingTemplate simpMessagingTemplate;

    public GreetingController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/greetings")
    public void greet(String greeting) {
        logger.info("Greeting for {}", greeting);

        String text = "[" + Instant.now() + "]: " + greeting;
        this.simpMessagingTemplate.convertAndSend("/topic/greetings", text);
    }

    @GetMapping(value = "/test")
	public <T> T test() {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		resultMap.put("ok", "ok");
		resultMap.put("version", "1.2");
		
		return (T) resultMap;
	}
}
