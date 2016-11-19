package cz.sizi.bikeo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.sizi.bikeo.model.Category;
import cz.sizi.bikeo.model.Video;
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
	public String showDashboardPage(Model model) {
		model.addAttribute("countEnabledVideos", videoService.getCount());
		model.addAttribute("countUnconfirmedVideos", videoService.getUnconfirmedCount());
		model.addAttribute("countUsers", userService.getCount());
		//TODO: aktivni pocet uzivatelu = uzivatele, kteri jsou enabled a zverejnili alespon jedno video
		model.addAttribute("countCategories", categoryService.getCount());
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
	 * Method for display video's detail
	 */
	@RequestMapping("/admin/video")
	public String showVideoDetail(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("videos", videoService.findAll());
		model.addAttribute("video", videoService.findById(id));
		model.addAttribute("categories", categoryService.findAll());
		return "video-detail";
	}

	/**
	 * Method for disable video
	 */
	@RequestMapping(value = "/admin/video/odstranit", method = RequestMethod.GET)
	public String removeVideo(@RequestParam("id") Integer id) {
		videoService.disable(videoService.findById(id));
		return "redirect:/admin/videa.html?remove=true";
	}

	/**
	 * Method for update video
	 */
	@RequestMapping(value = "/admin/video/upravit", method = RequestMethod.POST)
	public String doEditCategory(Model model, @RequestParam("id") Integer id, BindingResult result) {
		if (result.hasErrors()) {
			return "video-detail";
		}
		model.addAttribute("updateVideo", videoService.findById(id));
		videoService.update(videoService.findById(id));
		return "redirect:/admin/videa.html?update=true";
	}

	@RequestMapping("/admin/users")
	public String showUsersPage() {
		return "users";
	}

}
