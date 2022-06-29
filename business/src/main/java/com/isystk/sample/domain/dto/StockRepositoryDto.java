package com.isystk.sample.domain.dto;

import com.isystk.sample.domain.entity.Stock;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockRepositoryDto extends Stock {

  String stockImageName;

  String stockImageData;
}