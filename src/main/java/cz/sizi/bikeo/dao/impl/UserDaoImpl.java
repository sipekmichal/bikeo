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
	public void disable(User user) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"update User set enabled = 0 where id = :id");
		query.setParameter("id", user.getId());
		query.executeUpdate();
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
				.createQuery("from User where enabled = 1").list();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
