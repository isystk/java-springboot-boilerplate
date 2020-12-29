package com.isystk.sample.common.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * メールテンプレート
 */
@Getter
@AllArgsConstructor
public enum MailTemplate implements Values {

  ENTRY_REGIST_TEMPORARY(1, "仮会員登録通知メール", MailTemplateDiv.ENTRY_REGIST),
  ENTRY_REGIST_VALID(2, "本登録完了通知メール", MailTemplateDiv.ENTRY_REGIST),
  ENTRY_REMIND(3, "新パスワード設定画面のお知らせメール", MailTemplateDiv.ENTRY_REGIST);

  private MailTemplate(int code, String text, MailTemplateDiv div) {
    this.code = code;
    this.text = text;
    this.div = div;
  }

  private final Integer code;
  private final String text;
  private final MailTemplateDiv div;

  /**
   * コードに一致する値を取得します。
   *
   * @param code
   * @return
   */
  public static MailTemplate getValue(Integer code) {
    if (code == null) {
      return null;
    }
    for (MailTemplate div : values()) {
      if (div.getCode().equals(code)) {
        return div;
      }
    }
    return null;
  }
}