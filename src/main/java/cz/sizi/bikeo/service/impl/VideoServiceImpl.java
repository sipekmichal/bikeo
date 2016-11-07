package cz.sizi.bikeo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.sizi.bikeo.dao.VideoDao;
import cz.sizi.bikeo.model.Video;
import cz.sizi.bikeo.service.VideoService;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoDao videoDao;

	@Override
	public List<Video> findAll() {
		return videoDao.findAll();
	}

	@Override
	public List<Video> findByDate(String date) {
		return videoDao.findByDate(date);
	}

	@Override
	public void enable(Video video) {
		videoDao.enable(video);
	}

	@Override
	public void save(Video video) {
		videoDao.save(video);
	}

	@Override
	public Video update(Video video) {
		return videoDao.update(video);
	}

	@Override
	public void remove(Video video) {
		videoDao.remove(video);
	}

	@Override
	public Video findById(Long id) {
		return videoDao.findById(id);
	}

	@Override
	public Video findByTitle(String title) {
		return videoDao.findByTitle(title);
	}
	
	@Override
	public List<Video> findByCategory(long category) {
		return videoDao.findByCategory(category);
	}
}
