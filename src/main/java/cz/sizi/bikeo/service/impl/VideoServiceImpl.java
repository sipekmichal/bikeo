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
	public void disable(Video video) {
		videoDao.disable(video);
	}

	@Override
	public Video findById(Integer id) {
		return videoDao.findById(id);
	}

	@Override
	public Video findByTitle(String title) {
		return videoDao.findByTitle(title);
	}
	
	@Override
	public List<Video> findByCategory(Integer category) {
		return videoDao.findByCategory(category);
	}

	@Override
	public int getCount() {
		return videoDao.getCount();
	}

	@Override
	public int getEnabledCount() {
		return videoDao.getEnabledCount();
	}

	@Override
	public int getDisabledCount() {
		return videoDao.getDisabledCount();
	}

	@Override
	public int getUnconfirmedCount() {
		return videoDao.getUnconfirmedCount();
	}

	@Override
	public List<Video> findEnabledAll() {
		return videoDao.findEnabledAll();
	}

	@Override
	public void setViews(Video video) {
		videoDao.setViews(video);
	}

	@Override
	public List<Video> searchVideosByKeyword(String keyword) {
		return videoDao.searchVideosByKeyword(keyword);
	}

	@Override
	public List<Video> findAllGroupedByPublishDateDesc() {
		return videoDao.findAllGroupedByPublishDateDesc();
	}

	@Override
	public List<Video> findAllGroupedByViewsDesc() {
		return videoDao.findAllGroupedByViewsDesc();
	}

	@Override
	public List<Video> findUnconfirmedAll() {
		return videoDao.findUnconfirmedAll();
	}

	@Override
	public void confirm(Video findById) {
		videoDao.confirm(findById);
	}
	
}
