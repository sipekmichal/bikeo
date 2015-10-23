package cz.sizi.bikeo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cz.sizi.bikeo.dao.GenericDao;

/**
 * @author Sipek Michal
 * @version 1.0
 * @since 2015-10-23
 */

public class GenericDaoHibernateImpl<T, PK> implements GenericDao<T, PK> {

	protected SessionFactory sessionFactory;
	private Class<T> type;

	public GenericDaoHibernateImpl(Class<T> type) {
		super();
		this.type = type;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return this.sessionFactory.getCurrentSession().createCriteria(type)
				.list();
	
	}

	@Override
	public T save(T t) {
		this.sessionFactory.getCurrentSession().save(t);
		return t;
	}

	@Override
	public void remove(T t) {
		this.sessionFactory.getCurrentSession().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(PK id) {
		
		return (T) sessionFactory.getCurrentSession().get(type, (Serializable) id);
	}

	@Override
	public T update(T t) {
		this.sessionFactory.getCurrentSession().merge(t);
		return t;
	}

}
