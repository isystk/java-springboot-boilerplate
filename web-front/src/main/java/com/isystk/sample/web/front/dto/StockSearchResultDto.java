package com.isystk.sample.web.front.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import com.isystk.sample.common.dto.Dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 投稿フロント表示用DTO
 */
@Getter
@Setter
public class StockSearchResultDto implements Dto {

  BigInteger stockId;

  String name;

  String detail;

  Integer price;

  String imgpath;

  String imgUrl;

  Integer quantity;

  LocalDateTime createdAt;

  String createdAtYYYYMMDD;

  String createdAtMMDD;

}
