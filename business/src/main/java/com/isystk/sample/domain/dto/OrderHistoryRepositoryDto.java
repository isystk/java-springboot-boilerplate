package com.isystk.sample.domain.dto;

import com.isystk.sample.domain.entity.OrderHistory;
import com.isystk.sample.domain.entity.Stock;
import com.isystk.sample.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderHistoryRepositoryDto extends OrderHistory {

  Stock stock;

  User user;
}