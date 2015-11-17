package cz.sizi.bikeo.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.sizi.bikeo.dao.UserDao;
import cz.sizi.bikeo.model.User;

/**
 * @author Sipek Michal
 * @version 1.0
 * @since 2015-10-23
 */

@Repository
public class UserDaoImpl extends GenericDaoHibernateImpl<User, Integer>
		implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

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

}
