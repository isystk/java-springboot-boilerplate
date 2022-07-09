package com.isystk.sample.web.front.controller.html.register.remind;

import static com.isystk.sample.common.FrontUrl.REGISTER_REMIND;

import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.front.service.RegisterRemindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * パスワードリセット
 */
@Controller
@Slf4j
@RequestMapping(path = REGISTER_REMIND)
public class RegisterRemindController extends AbstractHtmlController {

  @Autowired
  RegisterRemindService registerRemindService;

  @Autowired
  RegisterRemindFormValidator registerRemindFormValidator;

  @ModelAttribute("entryRemindForm")
  public RegisterRemindForm entryRemindForm() {
    return new RegisterRemindForm();
  }

  @InitBinder("entryRemindForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(registerRemindFormValidator);
  }

  @Override
  public String getFunctionName() {
    return "F_REGISTER_REMIND";
  }

  /**
   * パスワード変更メール送信処理
   *
   * @param form
   * @param br
   * @return
   */
  @PostMapping
  public String registOnetimePass(@Validated @ModelAttribute RegisterRemindForm form,
      BindingResult br, RedirectAttributes attributes) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return "redirect:/password/reset";
    }

    // パスワード変更ワンタイムパス登録
    registerRemindService.registOnetimePass(form.getEmail());

    return "redirect:/password/reset";
  }


}
