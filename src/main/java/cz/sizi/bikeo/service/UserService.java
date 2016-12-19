package cz.sizi.bikeo.service;

import cz.sizi.bikeo.dao.UserDao;
import cz.sizi.bikeo.model.User;

public interface UserService extends UserDao {
	User findByLoggedName(String username);

}
