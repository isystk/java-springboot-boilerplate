package com.isystk.sample.web.front.controller.html.password.config;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class PasswordResetConfigForm implements Serializable {

  private static final long serialVersionUID = 7593564324192730932L;

  /**
   * パスワード
   */
  @NotBlank
  @Size(max = 100)
  String password;

  /**
   * パスワード(確認用)
   */
  @NotBlank
  @Size(max = 100)
  String passwordConfirmation;

}
