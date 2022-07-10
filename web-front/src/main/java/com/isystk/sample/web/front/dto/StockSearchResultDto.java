package com.isystk.sample.web.front.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import com.isystk.sample.common.dto.Dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 商品フロント表示用DTO
 */
@Getter
@Setter
public class StockSearchResultDto implements Dto {

  @JsonProperty("id")
  BigInteger stockId;

  String name;

  String detail;

  Integer price;

  String imgpath;

  @JsonProperty("img_url")
  String imgUrl;

  Integer quantity;

  LocalDateTime createdAt;

  String createdAtYYYYMMDD;

  String createdAtMMDD;

}
