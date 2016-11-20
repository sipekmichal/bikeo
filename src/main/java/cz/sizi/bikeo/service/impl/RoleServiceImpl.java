package cz.sizi.bikeo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.sizi.bikeo.dao.RoleDao;
import cz.sizi.bikeo.model.Role;
import cz.sizi.bikeo.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List <Role> findByRoleName(String roleName) {
		return roleDao.findByRoleName(roleName);
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public List<Role> findEnabledAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Role t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role update(Role t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disable(Role t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role findById(Integer p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
