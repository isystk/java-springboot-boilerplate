package com.isystk.sample.web.front.controller.html.entry;

import static com.isystk.sample.web.base.FrontUrl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.entity.TUser;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.front.service.EntryService;
import com.isystk.sample.web.front.service.PostService;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * 会員登録ログイン
 */
@Controller
@Slf4j
public class EntryHtmlController extends AbstractHtmlController {

    @Autowired
    EntryService entryService;

    @Override
    public String getFunctionName() {
        return "A_ENTRY";
    }

    /**
     * 登録画面表示
     *
     * @param form
     * @param model
     * @return
     */
    @GetMapping(ENTRY_REGIST_URL)
    public String index(@ModelAttribute EntryHtmlForm form, Model model) {
        return "modules/entry/regist/index";
    }

	/**
	 * 登録表示
	 * @param post
	 * @param model
	 * @return
	 */
	@GetMapping("regist")
	public String regist(@ModelAttribute("entryHtmlForm") EntryHtmlForm form, Model model) {

		// 入力値からDTOを作成する
		val inputPost = modelMapper.map(form, TUser.class);

		entryService.regist(inputPost);

		return "redirect:/member/";
	}

}
