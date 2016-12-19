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
		return sessionFactory.getCurrentSession().createQuery("from Video").list();
	}

	@SuppressWarnings("unchecked")
	public List<Video> findAllGroupedByPublishDateDesc() {
		return sessionFactory.getCurrentSession().createQuery("from Video where confirmed = 1 order by publishDate DESC").list();
	}

	@Override
	public void save(Video video) {
		sessionFactory.getCurrentSession().save(video);
		logger.info("Video saved successfully, Video detail: " + video.getId() + video.getUrl() + video.getTitle()
				+ video.getEnabled());
	}

	@Override
	public void disable(Video video) {
		Query query = sessionFactory.getCurrentSession().createQuery("update Video set enabled = 0 where id = :id");
		query.setParameter("id", video.getId());
		query.executeUpdate();
		logger.info("Video disabled successfully, Video detail: " + video.getId() + video.getUrl() + video.getTitle()
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
				.createQuery("from Video where publishDate like ':date%' and enabled = 1");
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

	@Override
	public Video findByTitle(String title) {
		return (Video) sessionFactory.getCurrentSession().createQuery("from Video where title = :title and confirmed = 1")
				.setParameter("title", title).uniqueResult();
	}

	@Override
	public List<Video> findByCategory(Integer category) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Video vid inner join vid.categories cat where cat.id = :category and vid.confirmed = 1");
		query.setParameter("category", category);
		@SuppressWarnings("unchecked")
		List<Video> videos = query.list();
		return videos;
	}

	@Override
	public int getCount() {
		return sessionFactory.getCurrentSession().createQuery("from Video").list().size();

	}

	@Override
	public int getEnabledCount() {
		return sessionFactory.getCurrentSession().createQuery("from Video where enabled = 1").list().size();

	}

	@Override
	public int getDisabledCount() {
		return sessionFactory.getCurrentSession().createQuery("from Video where enabled = 0").list().size();

	}

	@Override
	public int getUnconfirmedCount() {
		return sessionFactory.getCurrentSession().createQuery("from Video where confirmed = 0").list().size();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> findEnabledAll() {
		return sessionFactory.getCurrentSession().createQuery("from Video where enabled = 1 and confirmed = 1").list();
	}

	@Override
	public void setViews(Video video) {
		Query query = sessionFactory.getCurrentSession().createQuery("update Video set views = :views where id = :id");
		query.setParameter("id", video.getId());
		query.setParameter("views", video.getViews() + 1);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> searchVideosByKeyword(String keyword) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Video where title like :searchKeyword and enabled = 1 and confirmed = 1")
				.setParameter("searchKeyword", "%" + keyword + "%").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> findAllGroupedByViewsDesc() {
		return sessionFactory.getCurrentSession().createQuery("from Video where confirmed = 1 order by length(views) DESC").list();
	}

}
