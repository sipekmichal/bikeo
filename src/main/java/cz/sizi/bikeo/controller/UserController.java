package cz.sizi.bikeo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.hibernate.validator.internal.constraintvalidators.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.sizi.bikeo.model.User;
import cz.sizi.bikeo.service.RoleService;
import cz.sizi.bikeo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registration(Model model) {
		User user = new User();
		model.addAttribute("userForm", user);
		return "registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getErrorCount());
			System.out.println(bindingResult.getAllErrors().toString());
			return "registration";
		}
		userService.save(user);
		return "redirect:/registrationSuccess";
	}
	
	@RequestMapping(value = "/registrationSuccess", method = RequestMethod.GET)
	public String registrationSucces() {
		return "registrationSuccess";
	}
}
