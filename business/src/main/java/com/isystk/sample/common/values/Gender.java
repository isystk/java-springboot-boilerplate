package com.isystk.sample.common.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性別
 */
@Getter
@AllArgsConstructor
public enum Gender implements Values {

  WOMAN("1", "女性"),
  MAN("2", "男性");

  private final String code;
  private final String text;

  /**
   * コードに一致する値を取得します。
   *
   * @param code
   * @return
   */
  public static Gender getValue(String code) {
    if (code == null) {
      return null;
    }
    for (Gender div : values()) {
      if (div.getCode().equals(code)) {
        return div;
      }
    }
    return null;
  }
}