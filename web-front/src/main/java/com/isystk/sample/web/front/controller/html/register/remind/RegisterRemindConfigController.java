package com.isystk.sample.web.front.controller.html.register.remind;

import static com.isystk.sample.common.FrontUrl.REGISTER_REMIND_CONFIG;

import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.front.service.RegisterRemindService;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 会員パスワード変更
 */
@Controller
@Slf4j
@RequestMapping(path = REGISTER_REMIND_CONFIG)
public class RegisterRemindConfigController extends AbstractHtmlController {

  @Autowired
  RegisterRemindService registerRemindService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  RegisterRemindConfigFormValidator registerRemindConfigFormValidator;

  @ModelAttribute("registerRemindConfigForm")
  public RegisterRemindConfigForm registerRemindConfigForm() {
    return new RegisterRemindConfigForm();
  }

  @InitBinder("registerRemindConfigForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(registerRemindConfigFormValidator);
  }

  @Override
  public String getFunctionName() {
    return "API_REGISTER_REMIND_CONFIG";
  }

  /**
   * パスワード変更画面表示
   *
   * @param onetimeKey
   * @return
   */
  @GetMapping("{onetimeKey}")
  public String config(@PathVariable String onetimeKey,
      @ModelAttribute RegisterRemindConfigForm form, Model model) {

//    // ワンタイムキーからユーザーIDを取得する
//    var tUserOnetimePass = registerRemindService.getTUserOnetimePass(onetimeKey);
//    if (tUserOnetimePass == null) {
//      throw new NoDataFoundException("指定されたワンタイムキーが見つかりません。[onetimeKey=" + onetimeKey + "]");
//    }

    form.setOnetimeKey(onetimeKey);

    return "redirect:/login";
  }

  /**
   * パスワード変更処理
   *
   * @return
   */
  @PostMapping
  public String changePassword(@Validated @ModelAttribute RegisterRemindConfigForm form,
      BindingResult br, RedirectAttributes attributes) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return "redirect:/password/reset";
    }

//    // ワンタイムキーからユーザーIDを取得する
//    var tUserOnetimePass = registerRemindService.getTUserOnetimePass(form.getOnetimeKey());
//    if (tUserOnetimePass == null) {
//      throw new NoDataFoundException(
//          "指定されたワンタイムキーが見つかりません。[onetimeKey=" + form.getOnetimeKey() + "]");
//    }

    // パスワードをハッシュ化する
    String password = passwordEncoder.encode(form.getPassword());

    // パスワード変更ワンタイムパス登録
    registerRemindService.changePassword(form.getOnetimeKey(), password);

    return "redirect:/password/reset";
  }

}
