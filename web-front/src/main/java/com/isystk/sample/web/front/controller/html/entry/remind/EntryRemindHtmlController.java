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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.front.service.EntryRemindService;

import lombok.extern.slf4j.Slf4j;

/**
 * 会員パスワード変更
 */
@Controller
@SessionAttributes(types = { EntryRemindForm.class})
@Slf4j
@RequestMapping(ENTRY_REMIND)
public class EntryRemindHtmlController extends AbstractHtmlController {

	@Autowired
	EntryRemindService entryRemindService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	EntryRemindFormValidator entryRemindFormValidator;

    @ModelAttribute("entryRemindForm")
    public EntryRemindForm entryRemindForm() {
        return new EntryRemindForm();
    }

    @InitBinder("entryRemindForm")
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(entryRemindFormValidator);
    }

	@Override
	public String getFunctionName() {
		return "F_ENTRY_REMIND";
	}

	/**
	 * パスワード変更メール送信画面表示
	 *
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping
	public String index(@ModelAttribute EntryRemindForm form, Model model) {

        // SessionAttributeを再生成する
        model.addAttribute("entryRemindForm", new EntryRemindForm());

		return "modules/entry/remind/index";
	}

	/**
	 * パスワード変更メール送信処理
	 *
	 * @param form
	 * @param br
	 * @param attributes
	 * @return
	 */
	@PostMapping
	public String registOnetimePass(@Validated @ModelAttribute EntryRemindForm form, BindingResult br,
			RedirectAttributes attributes) {

		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return "modules/entry/remind/index";
		}

		// パスワード変更ワンタイムパス登録
		entryRemindService.registOnetimePass(form.getEmail());

		return "redirect:/entry/remind/sendmail";
	}

	/**
	 * 完了画面表示
	 *
	 * @return
	 */
	@GetMapping("sendmail")
	public String showComplete() {
		return "modules/entry/remind/sendmail";
	}


}
