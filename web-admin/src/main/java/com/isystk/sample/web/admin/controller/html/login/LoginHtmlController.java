package com.isystk.sample.web.admin.controller.html.login;

import static com.isystk.sample.web.base.WebConst.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String index(@ModelAttribute LoginForm form, Model model) {
        return "modules/login/login";
    }

    /**
     * 入力チェック
     *
     * @param form
     * @param br
     * @return
     */
    @PostMapping(LOGIN_URL)
    public String index(@Validated @ModelAttribute LoginForm form, BindingResult br) {
        // 入力チェックエラーがある場合は、元の画面にもどる
        if (br.hasErrors()) {
            return "modules/login/login";
        }

        return "forward:" + LOGIN_PROCESSING_URL;
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
        attributes.addFlashAttribute(GLOBAL_MESSAGE, getMessage("login.success"));
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
        model.addAttribute(GLOBAL_MESSAGE, getMessage("login.failed"));
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
        model.addAttribute(GLOBAL_MESSAGE, getMessage("login.timeout"));
        return "modules/login/login";
    }

    /**
     * ログアウト
     *
     * @return
     */
    @GetMapping(LOGOUT_SUCCESS_URL)
    public String logoutSuccess(@ModelAttribute LoginForm form, RedirectAttributes attributes) {
        attributes.addFlashAttribute(GLOBAL_MESSAGE, getMessage("logout.success"));
        return "redirect:/login";
    }

    @Override
    public boolean authorityRequired() {
        // 権限チェックを求めない
        return false;
    }
}
