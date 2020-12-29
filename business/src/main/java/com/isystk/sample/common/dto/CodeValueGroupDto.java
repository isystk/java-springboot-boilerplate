package com.isystk.sample.common.dto;

import com.isystk.sample.common.values.Values;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 名称とコードのグループ DTO
 */
@Getter
@Setter
public class CodeValueGroupDto implements Dto {

  public CodeValueGroupDto(String groupName, List<CodeValueDto> codeValueDtoList) {
    this.name = groupName;
    this.data = codeValueDtoList;
  }

  String name;

  List<CodeValueDto> data;
}
