package com.isystk.sample.web.front.dto.auth;

import com.isystk.sample.common.dto.Dto;
import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Column;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

@Setter
@Getter
public class AuthUserDto implements Dto {

  /**
   * 会員ID
   */
  Integer userId;

  /**
   * 姓
   */
  String familyName;

  /**
   * 名
   */
  String name;

  /**
   * セッションID
   */
  String sessionId;

}
