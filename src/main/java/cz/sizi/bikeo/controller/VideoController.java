package cz.sizi.bikeo.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
public class VideoController {

	private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

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
	 */
	@RequestMapping("/videa")
	public String showAllEnabledVideos(Model model) {
		model.addAttribute("videos", videoService.findEnabledAll());
		return "index";
	}
	
	/**
	 * Method displays page with all videos ordered by publish date
	 */
	@RequestMapping("/videa/nejnovejsi")
	public String showAllEnabledVideosOrderByPublishDate(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("videos", videoService.findAllGroupedByPublishDateDesc());
		return "index";
	}
	
	/**
	 * Method displays page with all videos ordered by views
	 */
	@RequestMapping("/videa/nejvice-sledovane")
	public String showAllEnabledVideosOrderByViews(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("videos", videoService.findAllGroupedByViewsDesc());
		return "index";
	}

	/**
	 * Method for display video's add page (addVideo.jsp)
	 */
	@RequestMapping("/pridat-video")
	public String showVideoAddPage(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return "video-add";
	}

	/**
	 * Method for save a video
	 */
	@RequestMapping(value = "/pridat-video", method = RequestMethod.POST)
	public String saveVideo(Model model, @ModelAttribute("video") Video video, BindingResult result) {

		// pokud dojde k chybe pri bindovani na formulari
		if (result.hasErrors()) {
			logger.error("Binding error: " + result);
			return showVideoAddPage(model);
		}

		try {
			Date publishDate = new Date();
			video.setPublishDate(publishDate);
			// video is disabled and confirmed by default
			video.setEnabled(true);
			video.setConfirmed(false);
			video.setYid(getYoutubeVideoId(video));
			video.setUrl(getValidUrl(video));
			video.setViews(0);
			
			//set logged user
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String authname = auth.getName(); //get logged user email
			video.setUser(userService.findByLoggedName(authname));
			
			videoService.save(video);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/addVideoSuccess";
	}
	
	@RequestMapping(value = "/addVideoSuccess", method = RequestMethod.GET)
	public String showVideoAddSuccess(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "addVideoSuccess";
	}

	/**
	 * Method for display video's detail (videoWatch.jsp)
	 */
	@RequestMapping("/watch")
	public String watchVideo(Model model, @RequestParam("v") Integer id, @ModelAttribute("video") Video video) {
		model.addAttribute("video", videoService.findById(id));
		model.addAttribute("videos", videoService.findEnabledAll());
		model.addAttribute("categories", categoryService.findAll());

		videoService.setViews(videoService.findById(id));
		return "videoWatch";
	}

	/**
	 * Method for processing youtube video link. Workaround the same-origin
	 * security policy on iframes.
	 */
	public String getValidUrl(Video video) {
		String url = "https://www.youtube.com/v/" + getYoutubeVideoId(video);
		return url;
	}

	/**
	 * Method for getting YouTube video Id as String
	 * 
	 * FOR EXAMPLE: When you enter url:
	 * https://www.youtube.com/watch?v=Hl-zzrqQoSE&list=PLFE2CE09D83EE3E28 then
	 * this method returns Hl-zzrqQoSE
	 */
	public String getYoutubeVideoId(Video video) {
		String url = video.getUrl();
		String[] tokens = url.split("be/|v=|&|\\?list");
		return tokens[1];
	}

	/**
	 * Binder for required date format
	 */
	@InitBinder
	public void setDateFormat(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, "publishDate", new CustomDateEditor(dateFormat, false));
	}

	/**
	 * Binder for resolving type mismatch and bind exceptions in POST
	 */
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