package com.isystk.sample.common.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 画像タイプ
 */
@Getter
@AllArgsConstructor
public enum ImageType implements Values {

  UNKNOWN("0", "不明"),
  STOCK("1", "商品"),
  CONTACT("2", "お問い合わせ");

  private final String code;
  private final String text;

  /**
   * コードに一致する値を取得します。
   *
   * @param code
   * @return
   */
  public static ImageType getValue(String code) {
    if (code == null) {
      return null;
    }
    for (ImageType div : values()) {
      if (div.getCode().equals(code)) {
        return div;
      }
    }
    return null;
  }

}