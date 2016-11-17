package cz.sizi.bikeo.dao;

import java.util.List;

public interface GenericDao<T, PK> {
	List<T> findAll();
	
	List<T> findEnabledAll();
	
	void save(T t);

	T update(T t);

	void disable(T t);

	T findById(PK p);
	
	int getCount();

}
