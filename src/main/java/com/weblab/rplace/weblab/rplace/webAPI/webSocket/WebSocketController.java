package com.weblab.rplace.weblab.rplace.webAPI.webSocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.weblab.rplace.weblab.rplace.business.abstracts.PixelService;
import com.weblab.rplace.weblab.rplace.entities.Pixel;

@Controller
public class WebSocketController {
	
	PixelService pixelService;
	
	@Autowired
	public WebSocketController(PixelService pixelService) {
		this.pixelService = pixelService;
	}
	
	

    @MessageMapping("/pixel") 
    @SendTo("/topic/pixels") 
    public Pixel handlePixels(Pixel pixel) {
    	pixelService.addPixel(pixel);
        return pixel;
    }
    
    
    
}

