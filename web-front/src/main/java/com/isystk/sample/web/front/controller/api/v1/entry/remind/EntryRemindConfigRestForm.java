package com.isystk.sample.web.front.controller.api.v1.entry.remind;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
class EntryRemindConfigRestForm implements Serializable {

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
  String passwordConf;

  @NotBlank
  String onetimeKey;
}
