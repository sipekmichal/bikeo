package cz.sizi.bikeo.service;

import cz.sizi.bikeo.dao.VideoDao;
import cz.sizi.bikeo.model.Video;

public interface VideoService extends VideoDao {

	Video findByTitle(String title);

}
