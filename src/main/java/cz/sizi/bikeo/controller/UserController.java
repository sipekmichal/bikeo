package cz.sizi.bikeo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import cz.sizi.bikeo.model.User;
import cz.sizi.bikeo.service.RoleService;
import cz.sizi.bikeo.service.UserService;

/**
 * The UserController class accepts input and converts it to commands for the
 * model - User and views related to user.
 * 
 * @author Sipek Michal
 * @version 1.0
 * @since 2015-10-23
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	
	@Autowired
	RoleService roleService;

	@ModelAttribute("user")
	public User construct() {
		return new User();
	}


}
