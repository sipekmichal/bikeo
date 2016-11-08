package cz.sizi.bikeo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.sizi.bikeo.dao.UserDao;
import cz.sizi.bikeo.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User findByUserName(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User where name = :name");
		query.setParameter("name", name);
		User user = (User) query.uniqueResult();
		logger.info(
				"User loaded successfully, User detail: " + user.getName() + user.getEmail() + user.getId().toString());
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
		logger.info("User saved successfully, User detail: " + user.getName() + user.getEmail() + user.getId());
	}

	@Override
	public User update(User user) {
		sessionFactory.getCurrentSession().update(user);
		logger.info("User updated successfully, User detail: " + user.getName() + user.getEmail() + user.getId());
		return user;
	}

	@Override
	public void remove(User user) {
		sessionFactory.getCurrentSession().delete(user);
		logger.info("User deleted successfully, User detail: " + user.getName() + user.getEmail() + user.getId());
	}

	@Override
	public User findById(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User where id = :id");
		query.setParameter("id", id);
		User user = (User) query.uniqueResult();
		logger.info("User loaded successfully, User detail: " + user.getName() + user.getEmail() + user.getId());
		return user;
	}

	@Override
	public void disable(User user) {
		// TODO
		logger.info("User disabled successfully, User detail: " + user.getName() + user.getEmail() + user.getId());
	}
}
