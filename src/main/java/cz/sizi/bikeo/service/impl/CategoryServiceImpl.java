package cz.sizi.bikeo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.sizi.bikeo.dao.CategoryDao;
import cz.sizi.bikeo.model.Category;
import cz.sizi.bikeo.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public void save(Category category) {
		categoryDao.save(category);
	}

	@Override
	public Category update(Category category) {
		return categoryDao.update(category);
	}

	@Override
	public void remove(Category category) {
		categoryDao.remove(category);
	}

	@Override
	public Category findById(Long id) {
		return categoryDao.findById(id);
	}

}
