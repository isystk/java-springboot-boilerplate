package com.isystk.sample.web.base.aop;

import com.isystk.sample.common.util.MessageUtils;
import com.isystk.sample.web.base.filter.UserIdAware;
import lombok.val;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.isystk.sample.common.Const.*;

public class SetModelAndViewInterceptor extends BaseHandlerInterceptor {

  private static final Logger log = org.slf4j.LoggerFactory
      .getLogger(SetModelAndViewInterceptor.class);
  @Value("${application.imageUploadLocation:#{systemProperties['java.io.tmpdir']}}") // 設定ファイルに定義されたアップロード先を取得する
  String imageUploadLocation;

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    // コントローラーの動作後
    if (isRestController(handler)) {
      // APIの場合はスキップする
      return;
    }

    if (modelAndView == null) {
      return;
    }

    val locale = LocaleContextHolder.getLocale();
    val pulldownOption = MessageUtils.getMessage(MAV_PULLDOWN_OPTION, locale);

    // ログインユーザーID
    UserIdAware user = null;
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication.getPrincipal() instanceof UserIdAware) {
      user = UserIdAware.class.cast(authentication.getPrincipal());
    }

    // 定数定義を画面に渡す
    Map<String, Object> constants = new HashMap<>();
    constants.put(MAV_PULLDOWN_OPTION, pulldownOption);
    modelAndView.addObject(MAV_CONST, constants);
    modelAndView.addObject(MAV_LOGIN_USER, user);

    // 入力エラーを画面オブジェクトに設定する
    retainValidateErrors(modelAndView);
  }

  /**
   * 入力エラーを画面オブジェクトに設定する
   *
   * @param modelAndView
   */
  protected void retainValidateErrors(ModelAndView modelAndView) {
    val model = modelAndView.getModelMap();

    if (model != null && model.containsAttribute(MAV_ERRORS)) {
      val errors = model.get(MAV_ERRORS);

      if (errors != null && errors instanceof BeanPropertyBindingResult) {
        val br = ((BeanPropertyBindingResult) errors);

        if (br.hasErrors()) {
          val formName = br.getObjectName();
          val key = BindingResult.MODEL_KEY_PREFIX + formName;
          model.addAttribute(key, errors);
          model.addAttribute(GLOBAL_DANGER_MESSAGE, MessageUtils.getMessage(VALIDATION_ERROR));
        }
      }
    }
  }
}
