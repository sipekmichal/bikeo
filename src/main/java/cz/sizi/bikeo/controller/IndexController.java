package cz.sizi.bikeo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.sizi.bikeo.service.RoleService;

/**
 * The IndexController class accepts input and converts it to commands for the
 * views related to main page
 * 
 * @author Sipek Michal
 * @version 1.0
 * @since 2015-10-23
 */

@Controller
public class IndexController {

	@Autowired
	RoleService roleService;

	/**
	 * Method redirects to index page
	 * */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(Model model) {
		model.addAttribute("roles", roleService.findAll());
		return "index";
	}
	
	/**
	 * Method redirects to index page
	 * */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndex2(Model model) {
		model.addAttribute("roles", roleService.findAll());
		return "index";
	}

}
