package cz.sizi.bikeo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.sizi.bikeo.dao.RoleDao;
import cz.sizi.bikeo.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}

	@Override
	public void save(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}

	@Override
	public Role update(Role role) {
		sessionFactory.getCurrentSession().update(role);
		return role;
	}

	@Override
	public void remove(Role role) {
		sessionFactory.getCurrentSession().delete(role);
	}

	@Override
	public Role findById(Long id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, (Serializable) id);
	}

	@Override
	public Role findByRoleName(String roleName) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Role where name = :roleName");
		query.setParameter("roleName", roleName);
		Role role = (Role) query.uniqueResult();
		return role;

	}

}
