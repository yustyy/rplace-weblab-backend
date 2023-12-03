package com.weblab.rplace.weblab.rplace.business.abstracts;

import java.util.List;

import com.weblab.rplace.weblab.rplace.core.utilities.results.DataResult;
import com.weblab.rplace.weblab.rplace.core.utilities.results.Result;
import com.weblab.rplace.weblab.rplace.entities.Pixel;

public interface PixelService  {

	
	DataResult<List<Pixel>> getBoard();
	
	Result addPixel(Pixel pixel);
	
	DataResult<Pixel> getByXAndY(int x, int y);
	
	
	
}
