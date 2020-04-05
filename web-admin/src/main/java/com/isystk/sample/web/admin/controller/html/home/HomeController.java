package com.isystk.sample.web.admin.controller.html.home;

import static com.isystk.sample.common.AdminUrl.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(HOME)
public class HomeController extends AbstractHtmlController {

	@Override
	public String getFunctionName() {
		return "A_HOME";
	}

	@GetMapping
	public String index(Model model) {
		return "modules/home/index";
	}

}
