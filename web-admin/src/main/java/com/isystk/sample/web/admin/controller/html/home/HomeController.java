package com.isystk.sample.web.admin.controller.html.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

@Controller
@RequestMapping("/")
public class HomeController extends AbstractHtmlController {

	@GetMapping
	public String index(Model model) {
		return "modules/home/index";
	}

}
