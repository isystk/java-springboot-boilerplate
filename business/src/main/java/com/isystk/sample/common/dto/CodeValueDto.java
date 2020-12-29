package com.isystk.sample.common.dto;

import com.isystk.sample.common.dto.Dto;
import com.isystk.sample.common.values.Values;
import lombok.Getter;
import lombok.Setter;

/**
 * 名称とコードのDTO
 */
@Getter
@Setter
public class CodeValueDto implements Dto {

  public CodeValueDto(Values values) {
    this.code = values.getCode();
    this.text = values.getText();
  }

  Integer code;

  String text;
}
