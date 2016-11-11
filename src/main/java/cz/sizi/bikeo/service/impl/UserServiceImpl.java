package cz.sizi.bikeo.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.sizi.bikeo.dao.RoleDao;
import cz.sizi.bikeo.dao.UserDao;
import cz.sizi.bikeo.model.Role;
import cz.sizi.bikeo.model.User;
import cz.sizi.bikeo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
    @Autowired
    private RoleDao roleDao;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void save(User user) {
        user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
        user.setRoles(new HashSet<Role>(roleDao.findAll()));
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
	public User findByUsername(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);

	}

}
