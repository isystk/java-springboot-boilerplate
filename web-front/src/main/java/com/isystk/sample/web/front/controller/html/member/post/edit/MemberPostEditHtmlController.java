package com.isystk.sample.web.front.controller.html.member.post.edit;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.entity.TPostTag;
import com.isystk.sample.domain.repository.TPostRepository;
import com.isystk.sample.domain.repository.dto.TPostRepositoryDto;
import com.isystk.sample.web.front.controller.html.member.post.edit.MemberPostEditForm;
import com.isystk.sample.web.front.controller.html.member.post.edit.MemberPostEditFormValidator;
import com.isystk.sample.web.front.service.PostService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(MEMBER_POST_EDIT)
@SessionAttributes(types = { MemberPostEditForm.class })
public class MemberPostEditHtmlController extends AbstractHtmlController {

	@Autowired
	PostService postService;

	@Autowired
	TPostRepository postRepository;

	@Autowired
	UserHelper userHelper;

	@Autowired
	MemberPostEditFormValidator memberPostFormValidator;

	@ModelAttribute("memberPostEditForm")
	public MemberPostEditForm memberPostEditForm() {
		return new MemberPostEditForm();
	}

	@InitBinder("memberPostEditForm")
	public void validatorBinder(WebDataBinder binder) {
		binder.addValidators(memberPostFormValidator);
	}

	@Override
	public String getFunctionName() {
		return "F_MEMBER_POST_EDIT";
	}

	/**
	 * 修正画面表示
	 *
	 * @param post
	 * @param model
	 * @return
	 */
	@GetMapping("{postId}")
	public String editIndex(@ModelAttribute MemberPostEditForm form, Model model) {

//		// SessionAttributeを再生成する
//		model.addAttribute("memberPostEditForm", new MemberPostEditForm());

		// 1件取得する
		val post = postRepository.findById(form.getPostId());
		if (!post.getUserId().equals(userHelper.getLoginUser().getUserId())) {
			throw new NoDataFoundException("データが見つかりません。post_id=" + form.getPostId() + " user_id=" + userHelper.getLoginUser().getUserId());
		}

		// 取得したDtoをFromに詰め替える
		ObjectMapperUtils.map(post, form);
		form.setPostImageId(Lists.newArrayList());
		if (post.getTPostImageList() != null) {
			for (TPostImage tPostImage : post.getTPostImageList()) {
				form.getPostImageId().add(tPostImage.getImageId());
			}
		}
		form.setPostTagId(Lists.newArrayList());
		if (post.getTPostTagList() != null) {
			for (TPostTag tPostTag : post.getTPostTagList()) {
				form.getPostTagId().add(tPostTag.getPostTagId());
			}
		}

		return "modules/member/post/edit/index";
	}

	/**
	 * 修正確認画面表示
	 *
	 * @param post
	 * @param model
	 * @return
	 */
	@PutMapping(params = "confirm")
	public String editConfirm(@Validated @ModelAttribute MemberPostEditForm form, BindingResult br,
			SessionStatus sessionStatus, RedirectAttributes attributes) {
		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return "modules/member/post/edit/index";
		}

		return "modules/member/post/edit/confirm";
	}

	/**
	 * 前に戻る
	 *
	 * @param post
	 * @param model
	 * @return
	 */
	@PutMapping(params = "back")
	public String editBack(@Validated @ModelAttribute MemberPostEditForm form, BindingResult br,
			SessionStatus sessionStatus, RedirectAttributes attributes) {
		return "modules/member/post/edit/index";
	}

	/**
	 * 更新処理
	 *
	 * @param form
	 * @param br
	 * @param postId
	 * @param sessionStatus
	 * @param attributes
	 * @return
	 */
	@PutMapping(params = "complete")
	public String updateComplete(@Validated @ModelAttribute MemberPostEditForm form, BindingResult br,
			SessionStatus sessionStatus, RedirectAttributes attributes) {

		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return "modules/member/post/edit/index";
		}

		// 入力値を詰め替える
		val tPostDto = ObjectMapperUtils.map(form, TPostRepositoryDto.class);
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
		// 更新する
		postService.update(tPostDto);

		// セッションのmemberPostFormをクリアする
		sessionStatus.setComplete();

		return "redirect:/member/post/edit/complete";
	}

	/**
	 * 修正完了画面表示
	 *
	 * @return
	 */
	@GetMapping("complete")
	public String showComplete() {
		return "modules/member/post/edit/complete";
	}

}
