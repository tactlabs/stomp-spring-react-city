package org.tact.demo.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.tact.demo.CityUtil;
import org.tact.demo.StateUtil;

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
        
        JSONObject cityObj = new JSONObject();

        try {
			cityObj.put("city", "city");			
	        
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
        
        this.simpMessagingTemplate.convertAndSend("/random/city", cityObj);
        
        //this.simpMessagingTemplate.convertAndSend("/random/city", city);
    }
    
    @Scheduled(cron = "*/4 * * * * *")
    public void printState() {
        //Instant now = Instant.now();    	
    	
    	String state = StateUtil.getRandomState();
    	
        logger.info("City {}", state);
        this.simpMessagingTemplate.convertAndSend("/random/state", state);
    }
}
