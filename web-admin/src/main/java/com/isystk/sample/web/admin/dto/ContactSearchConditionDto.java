package com.isystk.sample.web.admin.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactSearchConditionDto {

  String userName;

  LocalDate createdAtFrom;

  LocalDate createdAtTo;

}