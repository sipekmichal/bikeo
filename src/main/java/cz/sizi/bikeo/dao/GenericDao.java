package cz.sizi.bikeo.dao;

import java.util.List;

/**
 * @author Sipek Michal
 * @version 1.0
 * @since 2015-10-23
 */

public interface GenericDao<T, PK>  {
   List<T> findAll();
   T save(T t);
   T update(T t);
   void remove(T t);
   T findById(PK id);
}
