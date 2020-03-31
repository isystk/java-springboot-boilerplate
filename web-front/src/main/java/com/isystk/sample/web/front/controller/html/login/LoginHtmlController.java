package com.isystk.sample.web.front.controller.html.login;

import static com.isystk.sample.web.base.WebConst.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.extern.slf4j.Slf4j;

/**
 * 管理側ログイン
 */
@Controller
@Slf4j
public class LoginHtmlController extends AbstractHtmlController {

    @Override
    public String getFunctionName() {
        return "A_LOGIN";
    }

    /**
     * 初期表示
     *
     * @param form
     * @param model
     * @return
     */
    @GetMapping(LOGIN_URL)
    public String index(@ModelAttribute LoginHtmlForm form, Model model) {
        return "modules/login/login";
    }

    /**
     * ログイン成功
     *
     * @param form
     * @param attributes
     * @return
     */
    @PostMapping(LOGIN_SUCCESS_URL)
    public String loginSuccess(@ModelAttribute LoginHtmlForm form, RedirectAttributes attributes) {
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
    public String loginFailure(@ModelAttribute LoginHtmlForm form, Model model) {
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
    public String loginTimeout(@ModelAttribute LoginHtmlForm form, Model model) {
        model.addAttribute(GLOBAL_DANGER_MESSAGE, getMessage("login.timeout"));
        return "modules/login/login";
    }

    /**
     * ログアウト
     *
     * @return
     */
    @GetMapping(LOGOUT_SUCCESS_URL)
    public String logoutSuccess(@ModelAttribute LoginHtmlForm form, RedirectAttributes attributes) {
        attributes.addFlashAttribute(GLOBAL_SUCCESS_MESSAGE, getMessage("logout.success"));
        return "redirect:/login";
    }

}
