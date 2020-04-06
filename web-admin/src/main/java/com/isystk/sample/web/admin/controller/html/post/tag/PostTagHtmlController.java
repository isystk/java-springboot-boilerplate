package com.isystk.sample.web.admin.controller.html.post.tag;

import static com.isystk.sample.common.FrontUrl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.isystk.sample.domain.dto.MPostTagCriteria;
import com.isystk.sample.domain.repository.MPostTagRepository;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(POST_TAG)
@SessionAttributes(types = { PostTagSearchForm.class })
public class PostTagHtmlController extends AbstractHtmlController {

	@Autowired
	MPostTagRepository mPostTagRepository;

	@Override
	public String getFunctionName() {
		return "A_POST_TAG";
	}

	/**
	 * 一覧画面表示
	 *
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping
	public String index(PostTagSearchForm form, Model model) {

		// 10件区切りで取得する
		val pages = mPostTagRepository.findAll(formToCriteria(form), form);

		// 画面に検索結果を渡す
		model.addAttribute("pages", pages);

		return "modules/post/tag/list";
	}

	/**
	 * 検索条件を詰める
	 * @return
	 */
	private MPostTagCriteria formToCriteria(PostTagSearchForm form) {

		// 入力値を詰め替える
		MPostTagCriteria criteria = new MPostTagCriteria();
		criteria.setNameLike(form.getPostTagName());
		criteria.setDeleteFlgFalse(true);
		criteria.setOrderBy("order by post_tag_id asc");

		return criteria;
	}

}
