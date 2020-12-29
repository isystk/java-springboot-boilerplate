package com.isystk.sample.web.front.controller.api.v1.entry.remind;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
class EntryRemindRestForm implements Serializable {

  private static final long serialVersionUID = 7593564324192730932L;

  /**
   * メールアドレス
   */
  @NotBlank
  @Email
  @Size(max = 100)
  String email;

}
