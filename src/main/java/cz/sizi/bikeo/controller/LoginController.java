package cz.sizi.bikeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String showLoginPage(){	
		return "login";
	}
	
	@RequestMapping("/loginfailed")
	public String showLoginFailedPage(Model model){	
		model.addAttribute("message", "Špatné pøihlašovací údaje!");
		return "login";
	}
}
