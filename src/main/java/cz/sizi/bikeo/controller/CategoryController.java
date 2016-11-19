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
import cz.sizi.bikeo.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@ModelAttribute("category")
	public Category construct() {
		return new Category();
	}

	/**
	 * Method displays page with all categories (categories.jsp)
	 */
	@RequestMapping("/admin/kategorie")
	public String showCategoriesPage(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "categories";
	}

	/**
	 * Method for display category's detail (categoryDetail.jsp)
	 */
	@RequestMapping("/admin/kategorie/detail")
	public String showCategoryDetailPage(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("category", categoryService.findById(id));
		return "categoryDetail";
	}

	/**
	 * Method for saving category
	 */
	@RequestMapping(value = "admin/kategorie", method = RequestMethod.POST)
	public String saveCategory(Model model, @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return showCategoriesPage(model);
		}
		category.setEnabled(true);
		categoryService.save(category);
		return "redirect:/admin/kategorie.html?success=true";
	}

	/**
	 * Method for disabling category
	 */
	@RequestMapping(value = "admin/kategorie/odstranit", method = RequestMethod.GET)
	public String removeCategory(@RequestParam("id") Integer id) {
		categoryService.disable(categoryService.findById(id));
		return "redirect:/admin/kategorie.html?remove=true";
	}

	/**
	 * Method for display categoryEdit.jsp page
	 */
	@RequestMapping("/admin/kategorie/upravit")
	public String showEditCategoryPage(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("categoryEdit", categoryService.findById(id));
		return "categoryEdit";
	}

	/**
	 * Method for saving the modified category
	 */
	@RequestMapping(value = "admin/kategorie/upravit", method = RequestMethod.POST)
	public String editCategory(@Valid @ModelAttribute("edit-category") Category category,
			@RequestParam("id") Integer id, BindingResult result) {
		if (result.hasErrors()) {
			return "categoryEdit";
		}
		categoryService.update(category);
		return "redirect:/admin/kategorie.html?update=true";
	}

}
