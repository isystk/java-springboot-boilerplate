package com.isystk.sample.web.front.controller.html.entry.remind;

import static com.isystk.sample.common.FrontUrl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.front.service.EntryRemindService;

import lombok.extern.slf4j.Slf4j;

/**
 * 会員パスワード変更
 */
@Controller
@SessionAttributes(types = { EntryRemindConfigForm.class })
@Slf4j
@RequestMapping(ENTRY_REMIND_CONFIG)
public class EntryRemindHtmlConfigController extends AbstractHtmlController {

	@Autowired
	EntryRemindService entryRemindService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	EntryRemindConfigFormValidator entryRemindConfigFormValidator;

    @ModelAttribute("entryRemindConfigForm")
    public EntryRemindConfigForm entryRemindConfigForm() {
        return new EntryRemindConfigForm();
    }

    @InitBinder("entryRemindConfigForm")
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(entryRemindConfigFormValidator);
    }

	@Override
	public String getFunctionName() {
		return "F_ENTRY_REMIND_CONFIG";
	}

	/**
	 * パスワード変更画面表示
	 *
	 * @param onetimeKey
	 * @return
	 */
	@GetMapping("{onetimeKey}")
	public String config(@PathVariable String onetimeKey, @ModelAttribute EntryRemindConfigForm form,  Model model) {

		// ワンタイムキーからユーザーIDを取得する
		var tUserOnetimePass = entryRemindService.getTUserOnetimePass(onetimeKey);
		if (tUserOnetimePass == null) {
			throw new NoDataFoundException("指定されたワンタイムキーが見つかりません。[onetimeKey=" + onetimeKey + "]");
		}

		form.setOnetimeKey(onetimeKey);

		return "modules/entry/remind/config";
	}

	/**
	 * パスワード変更処理
	 *
	 * @return
	 */
	@PostMapping
	public String changePassword(@Validated @ModelAttribute EntryRemindConfigForm form, BindingResult br,
			RedirectAttributes attributes) {

		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return "modules/entry/remind/config";
		}

		// ワンタイムキーからユーザーIDを取得する
		var tUserOnetimePass = entryRemindService.getTUserOnetimePass(form.getOnetimeKey());
		if (tUserOnetimePass == null) {
			throw new NoDataFoundException("指定されたワンタイムキーが見つかりません。[onetimeKey=" + form.getOnetimeKey() + "]");
		}

		// パスワードをハッシュ化する
		String password = passwordEncoder.encode(form.getPassword());

		// パスワード変更ワンタイムパス登録
		entryRemindService.changePassword(form.getOnetimeKey(), password);

		return "redirect:/entry/remind/config/complete";
	}

	/**
	 * 完了画面表示
	 *
	 * @return
	 */
	@GetMapping("complete")
	public String showComplete() {
		return "modules/entry/remind/complete";
	}

}
