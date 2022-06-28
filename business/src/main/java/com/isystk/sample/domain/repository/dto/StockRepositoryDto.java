package com.isystk.sample.domain.repository.dto;

import com.isystk.sample.domain.entity.Stocks;
import com.isystk.sample.domain.entity.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockRepositoryDto extends Stocks {

  String stockImageName;

  String stockImageData;
}