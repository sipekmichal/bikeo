package cz.sizi.bikeo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.sizi.bikeo.dao.VideoDao;
import cz.sizi.bikeo.model.Video;

@Repository
public class VideoDaoImpl implements VideoDao {

	private static final Logger logger = LoggerFactory.getLogger(VideoDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Video where enabled=1 order by publishDate desc")
				.list();
	}

	@Override
	public void save(Video video) {
		sessionFactory.getCurrentSession().save(video);
		logger.info("Video saved successfully, Video detail: " + video.getId() + video.getUrl() + video.getTitle()
				+ video.getEnabled());
	}

	@Override
	public void remove(Video video) {
		sessionFactory.getCurrentSession().delete(video);
		logger.info("Video deleted successfully, Video detail: " + video.getId() + video.getUrl() + video.getTitle()
				+ video.getEnabled());
	}

	@Override
	public Video findById(Integer id) {
		return (Video) sessionFactory.getCurrentSession().get(Video.class, (Serializable) id);
	}

	@Override
	public Video update(Video video) {
		sessionFactory.getCurrentSession().update(video);
		logger.info("Video updated successfully, Video detail: " + video.getId() + video.getUrl() + video.getTitle()
				+ video.getEnabled());
		return video;
	}

	@Override
	public List<Video> findByDate(String date) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Video where publishDate like ':date%' order by publishDate ASC");
		query.setParameter("date", date);
		@SuppressWarnings("unchecked")
		List<Video> videos = query.list();
		return videos;
	}

	@Override
	public void enable(Video video) {
		Query query = sessionFactory.getCurrentSession().createQuery("update Video set enabled = 1 where id = :id");
		query.setParameter("id", video.getId());
		query.executeUpdate();
		logger.info("Video enabled successfully, Video detail: " + video.getId() + video.getUrl() + video.getTitle()
				+ video.getEnabled());
	}

	// TODO: dotaz vylepsit, tohle je prasarna
	@Override
	public Video findByTitle(String title) {
		return (Video) sessionFactory.getCurrentSession().createQuery("from Video where title='" + title + "'")
				.uniqueResult();
	}
	
  	@Override
	public List<Video> findByCategory(Integer category) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Video vid inner join vid.categories cat where cat.id = :category");
		query.setParameter("category", category);
		@SuppressWarnings("unchecked")
		List<Video> videos = query.list();
		return videos;
	}

}
