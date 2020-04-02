package com.isystk.sample.web.front.controller.html.entry;

import static com.isystk.sample.web.base.FrontUrl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isystk.sample.domain.entity.TUser;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.front.service.EntryService;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * 会員登録ログイン
 */
@Controller
@Slf4j
@RequestMapping(ENTRY_REGIST_URL)
public class EntryHtmlController extends AbstractHtmlController {

	@Autowired
	EntryService entryService;

	@Autowired
	PasswordEncoder passwordEncoder;

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
	@GetMapping
	public String index(@ModelAttribute EntryHtmlForm form, Model model) {
		return "modules/entry/regist/index";
	}

	/**
	 * 仮会員登録処理
	 *
	 * @param post
	 * @param model
	 * @return
	 */
	@PostMapping
	public String ontime(@Validated @ModelAttribute("entryHtmlForm") EntryHtmlForm form, BindingResult br,
			RedirectAttributes attributes) {

		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return "modules/entry/regist/index";
		}

		// 入力値からDTOを作成する
		val inputUser = modelMapper.map(form, TUser.class);
		val password = form.getPassword();

		// パスワードをハッシュ化する
		inputUser.setPassword(passwordEncoder.encode(password));

		// 仮会員登録
		entryService.registTemporary(inputUser);

		return "modules/entry/regist/confirm";
	}

	/**
	 * 本会員登録処理
	 *
	 * @param onetimeKey
	 * @return
	 */
	@GetMapping("{onetimeKey}")
	public String complete(@PathVariable String onetimeKey, Model model) {

		// 本会員登録
		entryService.registComplete(onetimeKey);

		return "modules/entry/regist/complete";
	}

}
