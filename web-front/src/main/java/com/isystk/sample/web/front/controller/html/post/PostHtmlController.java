package com.isystk.sample.web.front.controller.html.post;

import static com.isystk.sample.common.FrontUrl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isystk.sample.web.front.service.PostService;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.domain.dao.TPostDao;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(POST)
public class PostHtmlController extends AbstractHtmlController {

	@Autowired
	TPostDao tPostDao;

	@Override
	public String getFunctionName() {
		return "F_POST";
	}

	/**
	 * 詳細画面表示
	 *
	 * @param postId
	 * @param model
	 * @return
	 */
	@GetMapping("{postId}")
	public String show(@PathVariable Integer postId, Model model) {
		var post = tPostDao.selectById(postId)
			.orElseThrow(() -> new NoDataFoundException("post_id=" + postId + " のデータが見つかりません。"));
		model.addAttribute("post", post);
		return "modules/post/index";
	}

}
