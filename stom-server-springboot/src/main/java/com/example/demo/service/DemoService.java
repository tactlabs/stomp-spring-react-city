package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.CityUtil;
import com.example.demo.StateUtil;

@Service
public class DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

    private final SimpMessagingTemplate simpMessagingTemplate;

    public DemoService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Scheduled(cron = "*/3 * * * * *")
    public void printCity() {
        //Instant now = Instant.now();    	
    	
    	String city = CityUtil.getRandomCity();
    	
        logger.info("City {}", city);
        this.simpMessagingTemplate.convertAndSend("/random/city", city);
    }
    
    @Scheduled(cron = "*/4 * * * * *")
    public void printState() {
        //Instant now = Instant.now();    	
    	
    	String state = StateUtil.getRandomState();
    	
        logger.info("City {}", state);
        this.simpMessagingTemplate.convertAndSend("/random/state", state);
    }
}
