package cz.sizi.bikeo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

	@Override
	public List<User> findAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from User").list();
	}

	@Override
	public User save(User user) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where id = :id");
		query.setParameter("id", id);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public void disable(User user) {
		// TODO Auto-generated method stub
		
	}
}
