package com.isystk.sample.web.admin.controller.html.post.regist;

import static com.isystk.sample.common.AdminUrl.*;

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
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.entity.TPostTag;
import com.isystk.sample.domain.repository.dto.TPostRepositoryDto;
import com.isystk.sample.web.admin.service.PostService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(POST_REGIST)
@SessionAttributes(types = { PostRegistForm.class })
public class PostRegistHtmlController extends AbstractHtmlController {

	@Autowired
	PostService postService;

	@Autowired
	PostRigstFormValidator postRigstFormValidator;

	@Autowired
	UserHelper userHelper;

    @ModelAttribute("postRegistForm")
    public PostRegistForm postRegistForm() {
        return new PostRegistForm();
    }

    @InitBinder("postRegistForm")
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(postRigstFormValidator);
    }

	@Override
	public String getFunctionName() {
		return "A_POST_REGIST";
	}

	/**
	 * 初期表示
	 *
	 * @param post
	 * @param model
	 * @return
	 */
	@GetMapping
	public String registIndex(@ModelAttribute PostRegistForm form, Model model) {

        // SessionAttributeを再生成する
        model.addAttribute("postRegistForm", new PostRegistForm());

		return showRegistIndex(model);
	}

	/**
	 * 登録画面表示
	 * @param model
	 * @return
	 */
	private String showRegistIndex(Model model) {
		// ユーザー一覧
		val userList = userHelper.getUserList();
		model.addAttribute("userList", userList);

		return "modules/post/regist/index";
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
	@PostMapping(params = "confirm")
	public String registConfirm(@Validated @ModelAttribute PostRegistForm form, BindingResult br,
			SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {
		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return showRegistIndex(model);
		}

		model.addAttribute("user", userHelper.getLoginUser(form.getUserId()));

		return "modules/post/regist/confirm";
	}

	/**
	 * 前に戻る
	 *
	 * @param post
	 * @param model
	 * @return
	 */
	@PostMapping(params = "back")
	public String registBack(@Validated @ModelAttribute PostRegistForm form, BindingResult br,
			SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {
		return showRegistIndex(model);
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
	@PostMapping(params = "complete")
	public String registComplete(@Validated @ModelAttribute PostRegistForm form, BindingResult br,
			SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {
		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return showRegistIndex(model);
		}

		// 入力値からDTOを作成する
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
		val postId = postService.create(tPostDto);

		return "redirect:/post/regist/complete";
	}

	/**
	 * 登録完了画面表示
	 *
	 * @return
	 */
	@GetMapping("complete")
	public String showComplete() {
		return "modules/post/regist/complete";
	}

}
