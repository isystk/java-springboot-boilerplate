package com.isystk.sample.web.front.controller.api.v1.auth;

import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dao.AuditInfoHolder;
import com.isystk.sample.domain.entity.User;
import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.Resource;
import com.isystk.sample.web.front.dto.auth.AuthUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Optional;

import static com.isystk.sample.common.FrontUrl.*;

@RestController
public class AuthController extends AbstractRestController {

  @Override
  public String getFunctionName() {
    return "API_AUTH";
  }

  @Autowired
  UserHelper userHelper;

  /**
   * ログインチェック
   *
   * @return
   */
  @PostMapping(API_V1_SESSION)
  public Resource session(HttpSession session) {

    String userId = AuditInfoHolder.getAuditUser();

    Resource resource = resourceFactory.create();
    if (Optional.of(userId).isEmpty() || "GUEST".equals(userId)) {
      AuthUserDto dto = new AuthUserDto();
      dto.setSessionId(session.getId());
      resource.setData(Arrays.asList(dto));
      resource.setMessage("未ログイン状態です。");
      return resource;
    }

    User user = userHelper.getUser();
    AuthUserDto dto = ObjectMapperUtils.map(user, AuthUserDto.class);
    dto.setSessionId(session.getId());
    resource.setData(Arrays.asList(dto));
    resource.setMessage("ログイン状態です。");
    resource.setResult(true);

    return resource;
  }
//
//  /**
//   * ログイン成功
//   *
//   * @return
//   */
//  @PostMapping(LOGIN_SUCCESS_URL)
//  public Resource loginSuccess(HttpSession session) {
//
//    // 最終ログイン日時を更新します。
//    userHelper.updateLastLogin();
//
//    Resource resource = resourceFactory.create();
//    User user = userHelper.getUser();
//    AuthUserDto dto = ObjectMapperUtils.map(user, AuthUserDto.class);
//    dto.setSessionId(session.getId());
//    resource.setData(Arrays.asList(dto));
//    resource.setMessage(getMessage("login.success"));
//    resource.setResult(true);
//
//    return resource;
//  }
//
//  /**
//   * ログイン失敗
//   *
//   * @return
//   */
//  @GetMapping(LOGIN_FAILURE_URL)
//  @ResponseStatus(HttpStatus.UNAUTHORIZED)
//  public Resource loginFailure(HttpServletResponse response) {
//    Resource resource = resourceFactory.create();
//    resource.setMessage(getMessage("login.failed"));
//    resource.setResult(false);
//    return resource;
//  }
//
//  /**
//   * ログアウト
//   *
//   * @return
//   */
//  @GetMapping(LOGOUT_SUCCESS_URL)
//  public Resource logoutSuccess() {
//    Resource resource = resourceFactory.create();
//    resource.setMessage(getMessage("login.success"));
//    resource.setResult(true);
//    return resource;
//  }

}
