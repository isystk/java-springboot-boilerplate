package com.isystk.sample.web.admin.controller.html.user;

import static com.isystk.sample.common.AdminUrl.USERS;

import com.isystk.sample.domain.dto.UserRepositoryDto;
import com.isystk.sample.web.admin.service.UserService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import java.math.BigInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(USERS)
public class UserDetailController extends AbstractHtmlController {

  @Autowired
  UserService userService;

  @Override
  public String getFunctionName() {
    return "A_USER_DETAIL";
  }

  /**
   * 詳細画面表示
   *
   * @param userId
   * @param model
   * @return
   */
  @GetMapping("{userId}")
  public String show(@PathVariable BigInteger userId, Model model) {
    UserRepositoryDto user = userService.findById(userId);
    model.addAttribute("user", user);
    return "modules/user/detail";
  }

}
