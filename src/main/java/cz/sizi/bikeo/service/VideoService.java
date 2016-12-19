package cz.sizi.bikeo.service;

import java.util.List;

import cz.sizi.bikeo.dao.VideoDao;
import cz.sizi.bikeo.model.Video;

public interface VideoService extends VideoDao {

	Video findByTitle(String title);
	
	List<Video> findByCategory(Integer category);
	
	int getEnabledCount();
	
	int getDisabledCount();
	
	int getUnconfirmedCount();
	
	void setViews(Video video);

	List<Video> searchVideosByKeyword(String keyword);
	
	List<Video> findAllGroupedByPublishDateDesc();

	List<Video> findAllGroupedByViewsDesc();

}
