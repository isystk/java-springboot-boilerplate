package com.isystk.sample.web.front.controller.html.top;

import static com.isystk.sample.common.FrontUrl.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(TOP)
public class TopHtmlController extends AbstractHtmlController {

	@Override
	public String getFunctionName() {
		return "F_TOP";
	}

	@GetMapping
	public String index(Model model) {
		return "modules/top/index";
	}

}
