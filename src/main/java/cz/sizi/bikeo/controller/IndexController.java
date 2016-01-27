package cz.sizi.bikeo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.sizi.bikeo.service.RoleService;
import cz.sizi.bikeo.service.VideoService;

@Controller
public class IndexController {

	@Autowired
	RoleService roleService;
	
	@Autowired
	VideoService videoService;

	/**
	 * Method redirects to index page
	 * */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(Model model) {
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("videos", videoService.findAll());
		return "index";	
	}

	
	/**
	 * Method redirects to index page
	 * */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndex2(Model model) {
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("videos", videoService.findAll());
		return "index";
	}

}
