package com.isystk.sample.common.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザーステータス
 */
@Getter
@AllArgsConstructor
public enum UserStatus implements Values {

  TEMPORARY("0", "仮登録"),
  VALID("1", "有効"),
  INVALID("2", "利用停止"),
  WITHDRAW("3", "退会者");

  private final String code;
  private final String text;

  /**
   * コードに一致する値を取得します。
   *
   * @param code
   * @return
   */
  public static UserStatus getValue(String code) {
    if (code == null) {
      return null;
    }
    for (UserStatus div : values()) {
      if (div.getCode().equals(code)) {
        return div;
      }
    }
    return null;
  }

}