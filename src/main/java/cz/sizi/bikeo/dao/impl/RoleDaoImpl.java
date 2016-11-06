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
	public void remove(Role role) {
		sessionFactory.getCurrentSession().delete(role);
		logger.info("Role deleted successfully, Role detail: " + role.getName() + role.getId());
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
		logger.info("Role loaded successfully, Role detail: " + role.getName() + role.getId());
		return role;

	}

}
