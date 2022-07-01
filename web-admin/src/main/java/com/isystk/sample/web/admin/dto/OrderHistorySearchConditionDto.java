package com.isystk.sample.web.admin.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderHistorySearchConditionDto {

  String userName;

  String stockName;

  LocalDate createdAtFrom;

  LocalDate createdAtTo;

}