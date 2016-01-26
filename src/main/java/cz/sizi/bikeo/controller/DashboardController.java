package cz.sizi.bikeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping("/admin")
	public String showDashboardPage() {
		return "dashboard";
	}

}
