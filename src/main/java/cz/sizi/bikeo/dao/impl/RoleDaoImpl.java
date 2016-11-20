package cz.sizi.bikeo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.sizi.bikeo.dao.RoleDao;
import cz.sizi.bikeo.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	private static final Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);

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
		logger.info("Role saved successfully, Role detail: " + role.getName() + role.getId());
	}

	@Override
	public Role update(Role role) {
		sessionFactory.getCurrentSession().update(role);
		logger.info("Role updated successfully, Role detail: " + role.getName() + role.getId());
		return role;
	}

	@Override
	public void disable(Role role) {
		Query query = sessionFactory.getCurrentSession().createQuery("update Role set enabled = 0 where id = :id");
		query.setParameter("id", role.getId());
		query.executeUpdate();
		logger.info("Role disabled successfully, Role detail: " + role.getName() + role.getId());
	}

	@Override
	public Role findById(Integer id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, (Serializable) id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findByRoleName(String roleName) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Role where name = :roleName");
		query.setParameter("roleName", roleName);
		Role role = (Role) query.uniqueResult();
		logger.info("Role loaded successfully, Role detail: " + role.getName() + role.getId());
		return query.list();

	}

	@Override
	public int getCount() {
		return sessionFactory.getCurrentSession().createQuery("from Role").list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findEnabledAll() {
		return sessionFactory.getCurrentSession().createQuery("from Role where enabled = 1").list();
	}

}
