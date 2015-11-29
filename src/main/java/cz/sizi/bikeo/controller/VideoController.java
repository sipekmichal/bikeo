package cz.sizi.bikeo.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.sizi.bikeo.model.Category;
import cz.sizi.bikeo.model.Video;
import cz.sizi.bikeo.service.CategoryService;
import cz.sizi.bikeo.service.UserService;
import cz.sizi.bikeo.service.VideoService;

@Controller
public class VideoController {

	@Autowired
	VideoService videoService;

	@Autowired
	UserService userService;
	
	@Autowired
	CategoryService categoryService;

	@ModelAttribute("video")
	public Video construct() {
		return new Video();
	}

	/**
	 * Method displays page with all videos
	 * */
	@RequestMapping("/videa")
	public String showAllVideos(Model model) {
		model.addAttribute("videos", videoService.findAll());
		return "index";
	}

	/**
	 * Method for display video's add page (addVideo.jsp)
	 * */
	@RequestMapping("/videa/pridat")
	public String showVideoAddPage(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return "addVideo";
	}

	/**
	 * Method for save a video
	 * */
	@RequestMapping(value = "/videa/pridat", method = RequestMethod.POST)
	public String saveVideo(Model model,
			@Valid @ModelAttribute("video") Video video, BindingResult result) {
		if (result.hasErrors()) {
			return showVideoAddPage(model);
		}
		Date publishDate = new Date();
		video.setPublishDate(publishDate);
		video.setEnabled(0);
		video.setUrl(processUrl(video));
		videoService.save(video);
		return "index";
	}

	/**
	 * Method for processing youtube video link.
	 * Workaround the same-origin security policy on iframes.
	 * */
	public String processUrl(Video video) {
		String url = video.getUrl();
		String[] tokens = url.split("be/|v=|&|\\?list");
		url = "https://www.youtube.com/v/" + tokens[1];
		return url;
	}
	
	/**
	 * Binder for required date format
	 * */
	@InitBinder
	public void setDateFormat(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, "publishDate",
				new CustomDateEditor(dateFormat, false));
	}
	
	/**
	 * Binder for resolving type mismatch and bind exceptions in POST
	 * */
	@InitBinder
	protected void setCategoryAsString(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Category.class, "categories", new PropertyEditorSupport() {
	    @Override
	    public void setAsText(String text) {
	        Category c = categoryService.findById(Integer.parseInt(text));
	        setValue(c);
	    }
	    });
	}

}
