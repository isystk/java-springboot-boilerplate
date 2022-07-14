package com.isystk.sample.web.front.controller.html.auth;

import static com.isystk.sample.common.FrontUrl.AUTH_GOOGLE_CALLBACK;

import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(AUTH_GOOGLE_CALLBACK)
public class GoogleController extends AbstractHtmlController {

  @Autowired
  UserHelper userHelper;

  @Override
  public String getFunctionName() {
    return "F_AUTH_GOOGLE";
  }

  @GetMapping
  public String index(OAuth2AuthenticationToken authentication,
                        @AuthenticationPrincipal OAuth2User oauth2User,
                        Model model) {


    return "redirect:/home";
  }

}
