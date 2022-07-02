package com.isystk.sample.common.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 年齢
 */
@Getter
@AllArgsConstructor
public enum Age implements Values {

  UNDER_19("1", "～19歳"),
  OVER_20("2", "20歳～29歳"),
  OVER_30("3", "30歳～39歳"),
  OVER_40("4", "40歳～49歳"),
  OVER_50("5", "50歳～59歳"),
  OVER_60("6", "60歳～");

  private final String code;
  private final String text;

  /**
   * コードに一致する値を取得します。
   *
   * @param code
   * @return
   */
  public static Age getValue(String code) {
    if (code == null) {
      return null;
    }
    for (Age div : values()) {
      if (div.getCode().equals(code)) {
        return div;
      }
    }
    return null;
  }

}