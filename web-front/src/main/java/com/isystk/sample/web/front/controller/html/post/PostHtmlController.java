package com.isystk.sample.web.front.controller.html.post;

import static com.isystk.sample.web.base.FrontUrl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isystk.sample.web.front.service.PostService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(POST_URL)
public class PostHtmlController extends AbstractHtmlController {

	@Autowired
	PostService postService;

	@Override
	public String getFunctionName() {
		return "F_POST";
	}

	/**
	 * 詳細画面表示
	 * @param postId
	 * @param model
	 * @return
	 */
	@GetMapping("{postId}")
	public String show(@PathVariable Integer postId, Model model) {
		model.addAttribute("post", postService.findById(postId));
		return "modules/post/index";
	}

}
