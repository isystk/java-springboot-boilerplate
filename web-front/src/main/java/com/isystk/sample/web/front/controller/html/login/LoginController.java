package com.isystk.sample.web.front.controller.html.login;

import static com.isystk.sample.common.Const.GLOBAL_DANGER_MESSAGE;
import static com.isystk.sample.common.Const.GLOBAL_SUCCESS_MESSAGE;
import static com.isystk.sample.common.Const.LOGIN_FAILURE_URL;
import static com.isystk.sample.common.Const.LOGIN_SUCCESS_URL;
import static com.isystk.sample.common.Const.LOGIN_TIMEOUT_URL;
import static com.isystk.sample.common.Const.LOGOUT_SUCCESS_URL;

import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 管理側ログイン
 */
@Controller
@Slf4j
public class LoginController extends AbstractHtmlController {

  @Autowired
  UserHelper userHelper;

  @Override
  public String getFunctionName() {
    return "F_LOGIN";
  }


  /**
   * ログイン成功
   *
   * @param form
   * @param attributes
   * @return
   */
  @PostMapping(LOGIN_SUCCESS_URL)
  public String loginSuccess(@ModelAttribute LoginForm form, RedirectAttributes attributes) {

    // 最終ログイン日時を更新します。
    userHelper.updateLastLogin();

    attributes.addFlashAttribute(GLOBAL_SUCCESS_MESSAGE, getMessage("login.success"));
    return "redirect:/";
  }

  /**
   * ログイン失敗
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping(LOGIN_FAILURE_URL)
  public String loginFailure(@ModelAttribute LoginForm form, Model model) {
    model.addAttribute(GLOBAL_DANGER_MESSAGE, getMessage("login.failed"));
    return "modules/login/login";
  }

  /**
   * タイムアウトした時
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping(LOGIN_TIMEOUT_URL)
  public String loginTimeout(@ModelAttribute LoginForm form, Model model) {
    model.addAttribute(GLOBAL_DANGER_MESSAGE, getMessage("login.timeout"));
    return "modules/login/login";
  }

  /**
   * ログアウト
   *
   * @return
   */
  @GetMapping(LOGOUT_SUCCESS_URL)
  public String logoutSuccess(@ModelAttribute LoginForm form, RedirectAttributes attributes) {
    attributes.addFlashAttribute(GLOBAL_SUCCESS_MESSAGE, getMessage("logout.success"));
    return "redirect:/login";
  }

}
