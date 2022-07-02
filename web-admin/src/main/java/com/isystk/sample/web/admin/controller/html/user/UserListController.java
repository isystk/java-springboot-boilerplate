package com.isystk.sample.web.admin.controller.html.user;

import static com.isystk.sample.common.AdminUrl.USERS;

import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.web.admin.dto.UserSearchConditionDto;
import com.isystk.sample.web.admin.service.UserService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping(USERS)
public class UserListController extends AbstractHtmlController {

  @Autowired
  UserService userService;

  @Autowired
  UserListFormValidator userListFormValidator;

  @Override
  public String getFunctionName() {
    return "A_USER_LIST";
  }

  @ModelAttribute("userListForm")
  public UserListForm userListForm() {
    return new UserListForm();
  }

  @InitBinder("userListForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(userListFormValidator);
  }

  /**
   * 一覧画面表示
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping
  public String index(@ModelAttribute @Valid UserListForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return "modules/user/list";
    }

    // 10件区切りで取得する
    val pages = userService.findPage(formToDto(form), form);

    // 画面に検索結果を渡す
    model.addAttribute("pages", pages);

    return "modules/user/list";
  }

  /**
   * 検索条件を詰める
   *
   * @return
   */
  private UserSearchConditionDto formToDto(
      UserListForm form) {

    // 入力値を詰め替える
    return ObjectMapperUtils.map(form, UserSearchConditionDto.class);
  }

}
