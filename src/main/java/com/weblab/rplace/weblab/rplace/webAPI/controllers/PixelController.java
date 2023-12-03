package com.weblab.rplace.weblab.rplace.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import com.weblab.rplace.weblab.rplace.business.abstracts.PixelService;
import com.weblab.rplace.weblab.rplace.core.utilities.results.DataResult;
import com.weblab.rplace.weblab.rplace.core.utilities.results.Result;
import com.weblab.rplace.weblab.rplace.core.utilities.results.SuccessDataResult;
import com.weblab.rplace.weblab.rplace.entities.Pixel;

@RestController
@RequestMapping("api/pixels")
@CrossOrigin(origins = {"http://192.168.1.7:5500", "http://127.0.0.1:5500", "http://localhost:5500/", "http://172.20.10.9:5500"})
public class PixelController {
	
	private PixelService pixelService;

	@Autowired
	public PixelController(PixelService pixelService) {
		this.pixelService = pixelService;
	}
	
	
	@PostMapping("/addPixel")
	public Result addPixel(@RequestBody Pixel pixel) {
		var result = pixelService.addPixel(pixel);
		
		return result;
		
	}
	
	
	@GetMapping("/getBoard")
	public DataResult<List<Pixel>> getBoard(){
		return pixelService.getBoard();
		
		
	}

	@GetMapping("getByXAndY")
	public DataResult<Pixel> getByXAndY(@RequestParam int x, int y){
		return pixelService.getByXAndY(x,y);
	}
}



