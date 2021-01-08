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

  Integer code;

  String text;
}
