package com.isystk.sample.common.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * メールテンプレート区分
 */
@Getter
@AllArgsConstructor
public enum MailTemplateGroup implements Values {

  ENTRY_REGIST("1", "会員登録"),

  STOCK_PAYMENT("2", "商品決算");

  private final String code;
  private final String text;

  /**
   * コードに一致する値を取得します。
   *
   * @param code
   * @return
   */
  public static MailTemplateGroup getValue(Long code) {
    if (code == null) {
      return null;
    }
    for (MailTemplateGroup div : values()) {
      if (div.getCode().equals(code)) {
        return div;
      }
    }
    return null;
  }
}