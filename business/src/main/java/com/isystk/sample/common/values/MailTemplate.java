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
	ENTRY_REGIST_VALID(2, "本登録完了通知メール", MailTemplateDiv.ENTRY_REGIST);

	private MailTemplate(int code, String text, MailTemplateDiv div) {
		this.code = code;
		this.text = text;
		this.div = div;
	}

	private final Integer code;
	private final String text;
	private final MailTemplateDiv div;

}