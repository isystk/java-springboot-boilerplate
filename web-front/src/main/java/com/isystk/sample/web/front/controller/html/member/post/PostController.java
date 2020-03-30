package com.isystk.sample.web.front.controller.html.member.post;

import static com.isystk.sample.web.base.FrontUrl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isystk.sample.domain.service.PostService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(MEMBER_POST_URL)
//@SessionAttributes(types = { SearchPostForm.class, PostForm.class })
public class PostController extends AbstractHtmlController {

	@Autowired
	PostService postService;

    @Autowired
    PostFormValidator postFormValidator;

	@Override
	public String getFunctionName() {
		return "A_POST";
	}

    @InitBinder("postForm")
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(postFormValidator);
    }

	/**
	 * 登録画面表示
	 * @param post
	 * @param model
	 * @return
	 */
	@GetMapping("regist")
	public String regist(@ModelAttribute("postForm") PostForm form, Model model) {
		if (!form.isNew()) {
			// SessionAttributeに残っている場合は再生成する
			model.addAttribute("postForm", new PostForm());
		}

		return "modules/member/post/regist";
	}

}
