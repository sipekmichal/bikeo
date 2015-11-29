package cz.sizi.bikeo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.sizi.bikeo.dao.CategoryDao;
import cz.sizi.bikeo.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	private static final Logger logger = LoggerFactory
			.getLogger(CategoryDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Category> findAll() {
		for (Category c : findAll()) {
			logger.info("Category List::" + c);
		}
		return sessionFactory.getCurrentSession().createQuery("from Category")
				.list();
	}

	@Override
	public Category save(Category category) {
		sessionFactory.getCurrentSession().save(category);
		logger.info("Category saved successfully, Category Details=" + category);
		return category;
	}

	@Override
	public Category update(Category category) {
		sessionFactory.getCurrentSession().update(category);
		logger.info("Category updated successfully, Category Details="
				+ category);
		return category;
	}

	@Override
	public void remove(Category category) {
		sessionFactory.getCurrentSession().delete(category);
		logger.info("Category deleted successfully, Category Details="
				+ category);
	}

	@Override
	public Category findById(Integer id) {
		Category category = (Category) sessionFactory.getCurrentSession().get(
				Category.class, (Serializable) id);
		logger.info("Category loaded successfully, Category Details=" + category);
		return category;
	}

}
