package cz.sizi.bikeo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.sizi.bikeo.dao.CategoryDao;
import cz.sizi.bikeo.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	private static final Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	@Override
	public void save(Category category) {
		sessionFactory.getCurrentSession().save(category);
		logger.info("Category saved successfully, Category detail: " + category.getName() + category.getId());
	}

	@Override
	public Category update(Category category) {
		sessionFactory.getCurrentSession().update(category);
		logger.info("Category updated successfully, Category detail: " + category.getName() + category.getId());
		return category;
	}

	@Override
	public void disable(Category category) {
		Query query = sessionFactory.getCurrentSession().createQuery("update Category set enabled = 0 where id = :id");
		query.setParameter("id", category.getId());
		query.executeUpdate();
		logger.info("Category disabled successfully, Category detail: " + category.getName() + category.getId());
	}

	@Override
	public Category findById(Integer id) {
		Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, (Serializable) id);
		logger.info("Category loaded successfully, Category detail: " + category.getName() + id);
		return category;
	}

}
