package com.isystk.sample.web.front.controller.html.member.post;

import static com.isystk.sample.common.FrontUrl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.web.front.controller.html.member.post.regist.MemberPostRegistForm;
import com.isystk.sample.web.front.controller.html.member.post.regist.MemberPostRigstFormValidator;
import com.isystk.sample.web.front.service.PostService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(MEMBER_POST_DELETE)
@SessionAttributes(types = { MemberPostRegistForm.class })
public class MemberPostDeleteHtmlController extends AbstractHtmlController {

	@Autowired
	PostService postService;

	@Autowired
	UserHelper userHelper;

	@Autowired
	MemberPostRigstFormValidator memberPostFormValidator;

	@ModelAttribute("memberPostForm")
	public MemberPostRegistForm memberPostForm() {
		return new MemberPostRegistForm();
	}

	@InitBinder("memberPostForm")
	public void validatorBinder(WebDataBinder binder) {
		binder.addValidators(memberPostFormValidator);
	}

	@Override
	public String getFunctionName() {
		return "F_MEMBER_POST_DELETE";
	}

	/**
	 * 削除処理
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("{id}")
	public String delete(@PathVariable Integer id) {
		postService.delete(id);
		return "redirect:/member/";
	}

}
