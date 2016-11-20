package cz.sizi.bikeo.dao;

import java.util.List;

import cz.sizi.bikeo.model.Role;

public interface RoleDao extends GenericDao<Role, Integer> {
	List<Role> findByRoleName(String roleName);

}
