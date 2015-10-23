package cz.sizi.bikeo.dao.impl;

import org.springframework.stereotype.Repository;

import cz.sizi.bikeo.dao.RoleDao;
import cz.sizi.bikeo.model.Role;

/**
 * @author Sipek Michal
 * @version 1.0
 * @since 2015-10-23
 */

@Repository
public class RoleDaoImpl extends GenericDaoHibernateImpl<Role, Integer> implements RoleDao {

	public RoleDaoImpl() {
		super(Role.class);
	}

}
