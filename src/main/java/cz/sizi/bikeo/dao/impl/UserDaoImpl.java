package cz.sizi.bikeo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.sizi.bikeo.dao.UserDao;
import cz.sizi.bikeo.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User findByName(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where name = :name");
		query.setParameter("name", name);
		User user = (User) query.uniqueResult();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from User").list();
	}

	// TODO: takhle ne, prepsat
	@Override
	public User save(User user) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(
				"INSERT INTO User(ID, EMAIL, ENABLED, NAME, PASSWD) "
				+ "VALUES (:id, :email, :enabled, :name, :passwd)");
		
		query.setParameter("id", user.getId());
		query.setParameter("enabled", 1);
		query.setParameter("email", user.getEmail());
		query.setParameter("name", user.getName());
		query.setParameter("passwd", user.getPasswd());
		query.executeUpdate();
		return user;
	}

	@Override
	public User update(User user) {
		sessionFactory.getCurrentSession().update(user);
		return user;
	}

	@Override
	public void remove(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public User findById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where id = :id");
		query.setParameter("id", id);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public void disable(User user) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"update User set enabled = 0 where id = :id");
		query.setParameter("id", user.getId());
		query.executeUpdate();		
	}
}
