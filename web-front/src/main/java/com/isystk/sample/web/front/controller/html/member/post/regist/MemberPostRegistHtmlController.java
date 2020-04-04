package com.isystk.sample.web.front.controller.html.member.post.regist;

import static com.isystk.sample.common.FrontUrl.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.entity.TPostDto;
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.entity.TPostTag;
import com.isystk.sample.web.front.service.PostService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(MEMBER_POST_REGIST)
@SessionAttributes(types = { MemberPostRegistForm.class })
public class MemberPostRegistHtmlController extends AbstractHtmlController {

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
		return "A_MEMBER_POST_REGIST";
	}

	/**
	 * 登録画面表示
	 *
	 * @param post
	 * @param model
	 * @return
	 */
	@GetMapping
	public String registIndex(@ModelAttribute("memberPostForm") MemberPostRegistForm form, Model model) {

		return "modules/member/post/regist/index";
	}

	/**
	 * 登録確認画面表示
	 *
	 * @param form
	 * @param br
	 * @param sessionStatus
	 * @param attributes
	 * @return
	 */
	@PostMapping("confirm")
	public String registConfirm(@Validated @ModelAttribute("memberPostForm") MemberPostRegistForm form, BindingResult br,
			SessionStatus sessionStatus, RedirectAttributes attributes) {
		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return "modules/member/post/index";
		}

		return "modules/member/post/regist/confirm";
	}

	/**
	 * 登録処理
	 *
	 * @param form
	 * @param br
	 * @param sessionStatus
	 * @param attributes
	 * @return
	 */
	@PostMapping("complete")
	public String registComplete(@Validated @ModelAttribute("memberPostForm") MemberPostRegistForm form, BindingResult br,
			SessionStatus sessionStatus, RedirectAttributes attributes) {
		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return "modules/member/post/regist/index";
		}

		// 入力値からDTOを作成する
		val tPostDto = ObjectMapperUtils.map(form, TPostDto.class);
		// ログインユーザーID
		tPostDto.setUserId(userHelper.getLoginUserId());
		// 投稿画像
		List<TPostImage> tPostImageList = Lists.newArrayList();
		if (form.getPostImageId() != null) {
			for (Integer imageId : form.getPostImageId()) {
				TPostImage tPostImage = new TPostImage();
				tPostImage.setImageId(imageId);
				tPostImageList.add(tPostImage);
			}
		}
		tPostDto.setTPostImageList(tPostImageList);
		// 投稿タグ
		List<TPostTag> tPostTagList = Lists.newArrayList();
		if (form.getPostTagId() != null) {
			for (Integer tagId : form.getPostTagId()) {
				TPostTag tPostTag = new TPostTag();
				tPostTag.setPostTagId(tagId);
				tPostTagList.add(tPostTag);
			}
		}
		tPostDto.setTPostTagList(tPostTagList);
		val postId = postService.create(tPostDto);

		return "modules/member/post/regist/complete";
	}

}
