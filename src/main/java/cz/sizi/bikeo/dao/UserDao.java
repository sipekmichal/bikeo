package cz.sizi.bikeo.dao;

import cz.sizi.bikeo.model.User;

public interface UserDao extends GenericDao<User, Integer> {
	void disable(User user);
	
	User findByLoggedName(String username);
}
