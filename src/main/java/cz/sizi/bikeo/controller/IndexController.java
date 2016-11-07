package cz.sizi.bikeo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.sizi.bikeo.service.VideoService;

@Controller
public class IndexController {

	
	@Autowired
	VideoService videoService;

	/**
	 * Method redirects to index page
	 * */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(Model model) {
		model.addAttribute("videos", videoService.findAll());
		return "index";	
	}

	
	/**
	 * Method redirects to index page
	 * */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndex2(Model model) {
		model.addAttribute("videos", videoService.findAll());
		return "index";
	}
	
	// Zkousel jsem Long i long id, ale vzdy to nadava na pretypovani. Nepise mi to ani kde se ta chyba s pretypovanim vyskytuje :(
	@RequestMapping(params={"id"}, value = "/category", method = RequestMethod.GET)
	public String showByCategory(Model model, @RequestParam("id") long id) {
		model.addAttribute("videos", videoService.findByCategory(id));
		return "index";
	}
	
}
