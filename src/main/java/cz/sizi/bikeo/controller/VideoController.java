package cz.sizi.bikeo.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
			@RequestParam("image") MultipartFile file,
			@ModelAttribute("video") Video video, BindingResult result) {
		
		//pokud dojde k chybe pri bindovani na formulari
		if (result.hasErrors()) {
			logger.error("Binding error: " + result);
			return showVideoAddPage(model);
		}

		try {
			Blob blob = Hibernate.createBlob(file.getInputStream());
			video.setImageBlob(blob);
			logger.info("Image loaded, it's available at: " + "/image/"
					+ video.getId() + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Date publishDate = new Date();
			video.setPublishDate(publishDate);
			video.setEnabled(0);
			video.setUrl(processUrl(video));
			videoService.save(video);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/index.html?success=true";
	}

	@RequestMapping("/image/{videoId}.png")
	public String accessTheVideoImage(Model model,
			@PathVariable("videoId") Long id, HttpServletResponse response) {
		Video video = videoService.findById(id);
		logger.debug("Video " + video.getId() + " found.");
		try {
			OutputStream out = response.getOutputStream();
			IOUtils.copy(video.getImage().getBinaryStream(), out);
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Method for processing youtube video link. Workaround the same-origin
	 * security policy on iframes.
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
	protected void setCategoryAsString(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Category.class, "categories",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(String text) {
						Category c = categoryService.findById(Long
								.parseLong(text));
						setValue(c);
					}
				});
	}

}
