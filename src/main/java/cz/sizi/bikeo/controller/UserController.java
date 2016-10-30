package cz.sizi.bikeo.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.sizi.bikeo.model.User;
import cz.sizi.bikeo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

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

		user.setEnabled(true);
		userService.save(user);

		return "redirect:/registrationSuccess";
	}

	@RequestMapping(value = "/registrationSuccess", method = RequestMethod.GET)
	public String registrationSucces() {
		return "registrationSuccess";
	}
}
