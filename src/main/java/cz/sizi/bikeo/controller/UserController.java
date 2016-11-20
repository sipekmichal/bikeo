package cz.sizi.bikeo.controller;

import java.util.HashSet;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.sizi.bikeo.model.Role;
import cz.sizi.bikeo.model.User;
import cz.sizi.bikeo.service.CategoryService;
import cz.sizi.bikeo.service.RoleService;
import cz.sizi.bikeo.service.UserService;
import cz.sizi.bikeo.service.VideoService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	VideoService videoService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	RoleService roleService;

	@ModelAttribute("user")
	public User construct() {
		return new User();
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationPublicPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("categories", categoryService.findEnabledAll());
		return "registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getErrorCount());
			System.out.println(bindingResult.getAllErrors().toString());
			return "registration";
		}

		if (!user.isValid()) {
			// zde vyhodit do jsp hlasku..nejdriv se ale pokusit najit na netu,
			// jak se to dela
		}

        user.setRoles(new HashSet<Role>(roleService.findByRoleName("ROLE_USER")));
		user.setEnabled(true);
		userService.save(user);

		return "redirect:/registrationSuccess";
	}

	@RequestMapping(value = "/registrationSuccess", method = RequestMethod.GET)
	public String showRegistrationSucces() {
		return "registrationSuccess";
	}

	/**
	 * Method displays all users (users.jsp)
	 */
	@RequestMapping("/admin/uzivatele")
	public String showUsersPage(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("roles", roleService.findAll());
		return "users";
	}

	/**
	 * Method for display user's detail (userDetail.jsp)
	 */
	@RequestMapping("/admin/uzivatele/detail")
	public String showUserDetailPage(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("user", userService.findById(id));
		return "userDetail";
	}

	/**
	 * Method for saving user
	 */
//	@RequestMapping(value = "admin/uzivatele", method = RequestMethod.POST)
//	public String saveUser(Model model, @Valid @ModelAttribute("user") User user, @RequestParam("id") Integer id,
//			BindingResult result) {
//		if (result.hasErrors()) {
//			return users(model);
//		}
//		user.setEnabled(true);;
//		userService.save(user);
//		return "redirect:/admin/users.html?success=true";
//	}

	/**
	 * Method for removing(disabling) user
	 */
	@RequestMapping(value = "admin/uzivatele/odstranit", method = RequestMethod.GET)
	public String removeUser(@RequestParam("id") Integer id) {
		userService.disable(userService.findById(id));
		return "redirect:/admin/uzivatele.html?remove=true";
	}

	/**
	 * Method for display userEdit.jsp page
	 */
	@RequestMapping("/admin/uzivatele/upravit")
	public String showEditUserPage(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("user", userService.findById(id));
		return "userEdit";
	}

	/**
	 * Method for saving the modified user
	 */
	@RequestMapping(value = "admin/uzivatele/upravit", method = RequestMethod.POST)
	public String editUser(Model model, @Valid @ModelAttribute("userEdit") User user, @RequestParam("id") Integer id,
			BindingResult result) {
		if (result.hasErrors()) {
			return showUsersPage(model);
		}
		userService.update(user);
		return "redirect:/admin/uzivatele.html?update=true";
	}
}
