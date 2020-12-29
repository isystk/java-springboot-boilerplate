package com.isystk.sample.common.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * メールテンプレート区分
 */
@Getter
@AllArgsConstructor
public enum MailTemplateDiv implements Values {

  ENTRY_REGIST(1, "会員登録");

  private MailTemplateDiv(int code, String text) {
    this.code = code;
    this.text = text;
  }

  private final Integer code;
  private final String text;

  /**
   * コードに一致する値を取得します。
   *
   * @param code
   * @return
   */
  public static MailTemplateDiv getValue(Integer code) {
    if (code == null) {
      return null;
    }
    for (MailTemplateDiv div : values()) {
      if (div.getCode().equals(code)) {
        return div;
      }
    }
    return null;
  }
}