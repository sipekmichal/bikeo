package cz.sizi.bikeo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User save(User user) {
		user.setPasswd(passwordEncoder.encode(user.getPasswd()));
		return userDao.save(user);
	}

	@Override
	public void remove(User user) {
		user = userDao.findById(user.getId());
		userDao.remove(user);
	}

	@Override
	public void disable(User user) {
		userDao.disable(user);
	}

	@Override
	public User findById(Long id) {
		User user = userDao.findById(id);
		return user;
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public User findByName(String name) {
		return userDao.findByName(name);
	}

}
