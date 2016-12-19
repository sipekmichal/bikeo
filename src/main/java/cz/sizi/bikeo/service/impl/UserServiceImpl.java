package cz.sizi.bikeo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.sizi.bikeo.dao.UserDao;
import cz.sizi.bikeo.model.User;
import cz.sizi.bikeo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void save(User user) {
        user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
        userDao.save(user);
	}

	@Override
	public void disable(User user) {
		userDao.disable(user);
	}

	@Override
	public User findById(Integer id) {
		User user = userDao.findById(id);
		return user;
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public User findByLoggedName(String username) {
		return userDao.findByLoggedName(username);

	}

	@Override
	public int getCount() {
		return userDao.getCount();
	}

	@Override
	public List<User> findEnabledAll() {
		return userDao.findEnabledAll();
	}

}
