package com.isystk.sample.web.front.controller.html.member.post;

import static com.isystk.sample.web.base.FrontUrl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.web.front.service.PostService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(MEMBER_POST_URL)
//@SessionAttributes(types = { SearchPostForm.class, PostForm.class })
public class MemberPostHtmlController extends AbstractHtmlController {

	@Autowired
	PostService postService;

    @Autowired
    UserHelper userHelper;

    @Autowired
    MemberPostHtmlFormValidator postFormValidator;

	@Override
	public String getFunctionName() {
		return "A_MEMBER_POST";
	}

    @InitBinder("postHtmlForm")
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
	public String regist(@ModelAttribute("postHtmlForm") MemberPostHtmlForm form, Model model) {
		if (!form.isNew()) {
			// SessionAttributeに残っている場合は再生成する
			model.addAttribute("postForm", new MemberPostHtmlForm());
		}

		return "modules/member/post/regist";
	}

	/**
	 * 登録処理
	 * @param post
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping
	public String regist(@Validated @ModelAttribute("postHtmlForm") MemberPostHtmlForm form, BindingResult br,
			SessionStatus sessionStatus, RedirectAttributes attributes) {
		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return "modules/post/regist";
		}

		// 入力値からDTOを作成する
		val inputPost = modelMapper.map(form, TPost.class);
		// ログインユーザーID
		inputPost.setUserId(userHelper.getLoginUserId());
		val createdPost = postService.create(inputPost);

		return "redirect:/member/";
	}

	/**
	 * 更新処理
	 * @param form
	 * @param br
	 * @param postId
	 * @param sessionStatus
	 * @param attributes
	 * @return
	 */
	@PutMapping("{postId}")
	public String update(@Validated @ModelAttribute("postHtmlForm") MemberPostHtmlForm form, BindingResult br,
			@PathVariable Integer postId, SessionStatus sessionStatus, RedirectAttributes attributes) {

		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return "modules/post/regist";
		}

		// 更新対象を取得する
		val post = postService.findById(postId);

		// 入力値を詰め替える
		modelMapper.map(form, post);

		// 更新する
		val updatedPost = postService.update(post);

		// セッションのpostFormをクリアする
		sessionStatus.setComplete();

		return "redirect:/post/" + updatedPost.getPostId();
	}

	/**
	 * 削除処理
	 * @param id
	 * @return
	 */
	@DeleteMapping("{id}")
	public String delete(@PathVariable Integer id) {
		postService.delete(id);
		return "redirect:/post";
	}

}
