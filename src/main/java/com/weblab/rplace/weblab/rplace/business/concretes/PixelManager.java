package com.weblab.rplace.weblab.rplace.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weblab.rplace.weblab.rplace.business.abstracts.PixelService;
import com.weblab.rplace.weblab.rplace.core.utilities.results.DataResult;
import com.weblab.rplace.weblab.rplace.core.utilities.results.ErrorResult;
import com.weblab.rplace.weblab.rplace.core.utilities.results.Result;
import com.weblab.rplace.weblab.rplace.core.utilities.results.SuccessDataResult;
import com.weblab.rplace.weblab.rplace.core.utilities.results.SuccessResult;
import com.weblab.rplace.weblab.rplace.dataAccess.abstracts.PixelDao;
import com.weblab.rplace.weblab.rplace.entities.Pixel;

@Service
public class PixelManager implements PixelService {

	private PixelDao pixelDao;
	
	@Autowired
	public PixelManager(PixelDao pixelDao) {
		this.pixelDao = pixelDao;
	}
	
	
	
	@Override
	public DataResult<List<Pixel>> getTable() {
		return new SuccessDataResult<List<Pixel>>(pixelDao.findAll(), "Tüm tablo getirildi!");
	}

	@Override
	public Result addPixel(Pixel pixel) {
		
		
		if(CheckIfFieldsNull(pixel)) {
			return new ErrorResult("x,y axisleri ve renk alanı boş olamaz!");
		}
		
		
		//pixel var ise bunu yap
		if(CheckIfPixelExists(pixel) == true) {
			var pixelToChange = pixelDao.findByXAndY(pixel.getX(), pixel.getY());
			
			pixelToChange.setColor(pixel.getColor());
			pixelDao.save(pixelToChange);
			
			return new SuccessResult("Pixel rengi değiştirildi!");
		}
		
		//pixel yok ise bunu yap
		
		
		pixelDao.save(pixel);
		
		return new SuccessResult("Pixel veritabanında oluşturuldu!");
		
		
		
		
		
	}

	private boolean CheckIfFieldsNull(Pixel pixel) {
		if(pixel.getX() == 0 || pixel.getColor()== ""  || pixel.getY()== 0) {
			return true;
		}
		return false;
	}



	private boolean CheckIfPixelExists(Pixel pixel) {
		
		var result = pixelDao.findByXAndY(pixel.getX(), pixel.getY());
		
		if(result == null) {
			return false;
		}
		
		return true;
		
		
	}



	@Override
	public DataResult<Pixel> getByXAndY(int x, int y) {
		
		return new SuccessDataResult<Pixel>(pixelDao.findByXAndY(x, y),"Pixel getirildi");
		
	}
	
	
	
	

}
