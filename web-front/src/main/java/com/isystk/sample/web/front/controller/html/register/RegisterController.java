package com.isystk.sample.web.front.controller.html.register;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.entity.User;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.front.service.RegisterService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.isystk.sample.common.FrontUrl.REGISTER;

/**
 * 会員登録
 */
@Controller
@Slf4j
@RequestMapping(path = REGISTER)
public class RegisterController extends AbstractHtmlController {

  @Autowired
  RegisterService registerService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  RegisterFormValidator registerFormValidator;

  @Autowired
  UserHelper userHelper;

  @ModelAttribute("form")
  public RegisterForm initForm() {
    return new RegisterForm();
  }

  @InitBinder("form")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(registerFormValidator);
  }

  @Override
  public String getFunctionName() {
    return "F_REGISTER";
  }

  /**
   * 仮会員登録処理
   *
   * @param registerForm
   * @param br
   * @return
   */
  @PostMapping
  public String index(@Validated @ModelAttribute("form") RegisterForm registerForm, BindingResult br, RedirectAttributes attributes) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
        setFlashAttributeErrors(attributes, br);
      return "modules/index";
    }

    // 入力値からDTOを作成する
    val inputUser = ObjectMapperUtils.map(registerForm, User.class);
    val password = registerForm.getPassword();

    // パスワードをハッシュ化する
    inputUser.setPassword(passwordEncoder.encode(password));

    // 仮会員登録
    registerService.registTemporary(inputUser);

    return "redirect:/register/sendMail";
  }

  /**
   * 仮会員登録メール再送信
   *
   * @return
   */
  @PostMapping("/resend")
  public String resend() {

    var userId = Optional.of(userHelper.getLoginUserId()).orElseThrow(() -> new NoDataFoundException("未ログイン状態です"));

    // 仮会員登録メール再送信
    registerService.sendMail(userId);

    return "redirect:/register/sendMail";
  }

  /**
   * 本会員登録処理
   *
   * @param onetimeKey
   * @return
   */
  @GetMapping("/valified/{onetimeKey}")
  public String valified(@PathVariable String onetimeKey, Model model) {

    // 本会員登録
    registerService.registComplete(onetimeKey);

    return "redirect:/register/complete";
  }

}
