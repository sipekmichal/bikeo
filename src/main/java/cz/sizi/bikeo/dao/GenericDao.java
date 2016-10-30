package cz.sizi.bikeo.dao;

import java.util.List;

public interface GenericDao<T, PK> {
	List<T> findAll();

	void save(T t);

	T update(T t);

	void remove(T t);

	T findById(Long l);
}
