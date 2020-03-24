package com.isystk.sample.web.admin.controller.html.post;

import static com.isystk.sample.web.base.WebConst.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isystk.sample.domain.dto.PostCriteria;
import com.isystk.sample.domain.dto.common.Pageable;
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
//
//	@GetMapping("{id}")
//	public String show(@PathVariable Long id, Model model) {
//		model.addAttribute("item", itemService.findOne(id));
//		return "modules/post/show";
//	}
//
//	@GetMapping("new")
//	public String newItem(@ModelAttribute("item") Item item, Model model) {
//		return "modules/post/new";
//	}
//
//	@GetMapping("{id}/edit")
//	public String edit(@PathVariable Long id, @ModelAttribute("item") Item item, Model model) {
//		model.addAttribute("item", itemService.findOne(id));
//		return "modules/post/edit";
//	}
//
//	@PostMapping
//	public String create(@ModelAttribute("item") @Validated Item item, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			return "modules/post/new";
//		} else {
//			itemService.save(item);
//			return "redirect:/items";
//		}
//	}
//
//	@PutMapping("{id}")
//	public String update(@PathVariable Long id, @ModelAttribute("item") @Validated Item item, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			model.addAttribute("item", item);
//			return "modules/post/edit";
//		} else {
//			item.setId(id);
//			itemService.update(item);
//			return "redirect:/items";
//		}
//	}
//
//	@DeleteMapping("{id}")
//	public String delete(@PathVariable Long id) {
//		itemService.delete(id);
//		return "redirect:/items";
//	}

}
