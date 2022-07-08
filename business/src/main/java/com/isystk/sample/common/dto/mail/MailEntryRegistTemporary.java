package com.isystk.sample.common.dto.mail;

import lombok.Getter;
import lombok.Setter;

/**
 * 仮会員登録メール
 */
@Getter
@Setter
public class MailEntryRegistTemporary {

  String userName;
  String domain;
  String onetimeKey;
}
