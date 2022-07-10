package com.isystk.sample.common.dto.mail;

import lombok.Getter;
import lombok.Setter;

/**
 * 商品決算完了メール
 */
@Getter
@Setter
public class MailStockPaymentComplete {

  String userName;
  Integer amount;
}
