package com.weblab.rplace.weblab.rplace.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weblab.rplace.weblab.rplace.entities.Pixel;

import java.util.List;

@Repository
public interface PixelDao extends JpaRepository<Pixel, Integer> {

	Pixel findByXAndY(int x, int y);

	List<Pixel> findAllByOrderByXAscYAsc();
	
}
