package com.isystk.sample.web.admin.controller.html.post;

import static com.isystk.sample.web.base.WebConst.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isystk.sample.domain.dto.PostCriteria;
import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.service.post.PostService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(ADMIN_POST_URL)
public class PostController extends AbstractHtmlController {

    @Autowired
    PostService postService;

	@Override
	public String getFunctionName() {
		return "A_POST";
	}

	/**
	 * 一覧画面表示
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping
	public String index(@ModelAttribute PostForm form, Model model) {
        // 入力値を詰め替える
        val criteria = modelMapper.map(form, PostCriteria.class);

        // 10件区切りで取得する
        val pages = postService.findAll(criteria, Pageable.NO_LIMIT);

        // 画面に検索結果を渡す
        model.addAttribute("pages", pages);

		return "modules/post/index";
	}

	/**
	 * 詳細画面表示
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("{id}")
	public String show(@PathVariable Integer id, Model model) {
		PostCriteria criteria = new PostCriteria();
		criteria.setPostId(id);
		model.addAttribute("post", postService.findOne(criteria));
		return "modules/post/show";
	}

	/**
	 * 登録画面表示
	 * @param post
	 * @param model
	 * @return
	 */
	@GetMapping("new")
	public String newItem(@ModelAttribute("post") TPost post, Model model) {
		return "modules/post/new";
	}

	/**
	 * 変更画面表示
	 * @param postId
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping("{postId}/edit")
	public String edit(@PathVariable Integer postId, @ModelAttribute("postForm") PostForm form, Model model) {
        // セッションから取得できる場合は、読み込み直さない
        if (!hasErrors(model)) {
            // 1件取得する
            val post = postService.findById(postId);

            // 取得したDtoをFromに詰め替える
            modelMapper.map(post, form);
        }

		return "modules/post/edit";
	}

	/**
	 * 登録処理
	 * @param post
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping
	public String create(@ModelAttribute("post") @Validated TPost post, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "modules/post/new";
		} else {
			postService.create(post);
			return "redirect:/post";
		}
	}

	@PutMapping("{id}")
	public String update(@PathVariable Integer id, @ModelAttribute("post") @Validated TPost post, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("post", post);
			return "modules/post/edit";
		} else {
			post.setPostId(id);
			postService.update(post);
			return "redirect:/post";
		}
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Integer id) {
		postService.delete(id);
		return "redirect:/post";
	}

}
