package cz.sizi.bikeo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cz.sizi.bikeo.service.CategoryService;
import cz.sizi.bikeo.service.VideoService;

@Controller
public class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	VideoService videoService;

	@Autowired
	CategoryService categoryService;

	/**
	 * Method displays page with searching result
	 */
	@RequestMapping("/search")
	public String searchAllEnabledVideos(@RequestParam(value = "keyword", required = false) String keyword,
			Model model) {
		model.addAttribute("categories", categoryService.findEnabledAll());

		if (keyword != null) {
			model.addAttribute("videos", videoService.searchVideosByKeyword(keyword));
		} else {
			logger.warn("Keyword is null!");
		}

		boolean isSearchEmpty = videoService.searchVideosByKeyword(keyword).isEmpty();
		model.addAttribute("isSearchEmpty", isSearchEmpty);

		return "searchResult";
	}
}
