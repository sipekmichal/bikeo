package cz.sizi.bikeo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.sizi.bikeo.service.RoleService;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory
			.getLogger(IndexController.class);

	@Autowired
	RoleService roleService;

	/**
	 * Method redirects to index page
	 * */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(Model model) {
		model.addAttribute("roles", roleService.findAll());
		logger.info("Index page loaded.");
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
