package com.isystk.sample.common.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性別
 */
@Getter
@AllArgsConstructor
public enum Sex implements Values {

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
  public static Sex getValue(String code) {
    if (code == null) {
      return null;
    }
    for (Sex div : values()) {
      if (div.getCode().equals(code)) {
        return div;
      }
    }
    return null;
  }
}