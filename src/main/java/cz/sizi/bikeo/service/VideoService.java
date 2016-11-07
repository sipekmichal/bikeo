package cz.sizi.bikeo.service;

import java.util.List;

import cz.sizi.bikeo.dao.VideoDao;
import cz.sizi.bikeo.model.Video;

public interface VideoService extends VideoDao {

	Video findByTitle(String title);
	List<Video> findByCategory(long category);
}
