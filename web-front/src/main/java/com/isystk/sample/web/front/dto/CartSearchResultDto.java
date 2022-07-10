package com.isystk.sample.web.front.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isystk.sample.common.dto.Dto;
import com.isystk.sample.domain.dto.CartRepositoryDto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * マイカート表示用DTO
 */
@Getter
@Setter
public class CartSearchResultDto implements Dto {

  @JsonProperty("data")
  List<CartRepositoryDto> cartList;

  String username;

  Integer count;

  Integer sum;

}
