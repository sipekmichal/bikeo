package cz.sizi.bikeo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.sizi.bikeo.service.CategoryService;
import cz.sizi.bikeo.service.VideoService;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	VideoService videoService;
	
	@Autowired
	CategoryService categoryService;

	/**
	 * Method redirects to index page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(Model model) {
		model.addAttribute("videos", videoService.findEnabledAll());
		model.addAttribute("categories", categoryService.findEnabledAll());
		return "index";
	}

	/**
	 * Method redirects to index page
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndex2(Model model) {
		model.addAttribute("videos", videoService.findEnabledAll());
		model.addAttribute("categories", categoryService.findEnabledAll());
		return "index";
	}

	/**
	 * Method for display videos by category
	 * */
	@RequestMapping(value = "/kategorie")
	public String showVideosByCategory(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("category", categoryService.findById(id));
		model.addAttribute("videos", videoService.findEnabledAll());
		return "indexFilteredByCat";
	}

}
