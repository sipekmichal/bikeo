package cz.sizi.bikeo.dao;

import java.util.List;

import cz.sizi.bikeo.model.Video;

public interface VideoDao extends GenericDao<Video, Integer> {
	List<Video> findByDate(String date);
	
	void enable(Video video);
	
	Video findByTitle(String tile);

	List<Video> findByCategory(Integer category);
	
	int getEnabledCount(Integer count);
	
	int getDisabledCount(Integer count);
	
	int getUnconfirmedCount(Integer count);

}
