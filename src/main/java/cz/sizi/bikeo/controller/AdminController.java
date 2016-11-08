package cz.sizi.bikeo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cz.sizi.bikeo.service.CategoryService;
import cz.sizi.bikeo.service.UserService;
import cz.sizi.bikeo.service.VideoService;

@Controller
public class AdminController {
	
	@Autowired
	VideoService videoService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;

	@RequestMapping("/admin")
	public String showDashboardPage() {
		return "dashboard";
	}
	
	@RequestMapping("/admin/videa")
	public String showVideosPage(Model model) {
		model.addAttribute("videos", videoService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("users", userService.findAll());
		return "videos";
	}
	
	/**
	 * Method for display videos's detail
	 * */
	@RequestMapping("/admin/video")
	public String showVideoDetail(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("videos", videoService.findAll());
		model.addAttribute("video", videoService.findById(id));
		model.addAttribute("categories", categoryService.findAll());
		return "video-detail";
	}	
	
	@RequestMapping("/admin/kategorie")
	public String showCategoriesPage() {
		return "categories";
	}
	
	@RequestMapping("/admin/users")
	public String showUsersPage() {
		return "users";
	}

}
