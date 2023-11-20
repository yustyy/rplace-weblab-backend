package com.weblab.rplace.weblab.rplace.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weblab.rplace.weblab.rplace.business.abstracts.PixelService;
import com.weblab.rplace.weblab.rplace.core.utilities.results.DataResult;
import com.weblab.rplace.weblab.rplace.core.utilities.results.Result;
import com.weblab.rplace.weblab.rplace.core.utilities.results.SuccessDataResult;
import com.weblab.rplace.weblab.rplace.entities.Pixel;

@RestController
@RequestMapping("api/pixels")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PixelController {
	
	private PixelService pixelService;
	
	
	@Autowired
	public PixelController(PixelService pixelService) {
		this.pixelService = pixelService;
	}
	
	
	@PostMapping("/addPixel")
	public Result addPixel(Pixel pixel) {
		var result = pixelService.addPixel(pixel);
		
		return result;
		
	}
	
	
	@GetMapping("/getBoard")
	public DataResult<List<Pixel>> getBoard(){
		return pixelService.getTable();
		
		
	}
	
	
	
	

}



