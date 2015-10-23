package cz.sizi.bikeo.dao;

import cz.sizi.bikeo.model.User;

/**
 * @author Sipek Michal
 * @version 1.0
 * @since 2014-10-13
 */

public interface UserDao extends GenericDao<User, Integer> {
	void disable(User user);

	User findByName(String name);
}
