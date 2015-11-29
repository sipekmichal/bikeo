package cz.sizi.bikeo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.sizi.bikeo.dao.VideoDao;
import cz.sizi.bikeo.model.Video;

@Repository
public class VideoDaoImpl implements VideoDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Video> findAll() {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Video where enabled=1 order by publishDate desc")
				.list();
	}

	@Override
	public Video save(Video video) {
		sessionFactory.getCurrentSession().save(video);
		return video;
	}

	@Override
	public void remove(Video video) {
		sessionFactory.getCurrentSession().delete(video);
	}

	@Override
	public Video findById(Integer id) {
		return (Video) sessionFactory.getCurrentSession().get(Video.class,
				(Serializable) id);
	}

	@Override
	public Video update(Video video) {
		sessionFactory.getCurrentSession().update(video);
		return video;
	}

	@Override
	public List<Video> findByDate(String date) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Video where publishDate like ':date%' order by publishDate ASC");
		query.setParameter("date", date);
		List<Video> videos = query.list();
		return videos;
	}

	@Override
	public void enable(Video video) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"update Video set enabled = 1 where id = :id");
		query.setParameter("id", video.getId());
		query.executeUpdate();
	}
}
