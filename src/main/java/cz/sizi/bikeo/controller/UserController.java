package cz.sizi.bikeo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import cz.sizi.bikeo.model.User;
import cz.sizi.bikeo.service.RoleService;
import cz.sizi.bikeo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;



}
