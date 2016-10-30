package cz.sizi.bikeo.dao;

import cz.sizi.bikeo.model.Role;

public interface RoleDao extends GenericDao<Role, Integer> {
	Role findByRoleName(String roleName);

}
