package com.isystk.sample.web.admin.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchConditionDto {

  String name;

  String email;

  LocalDate createdAtFrom;

  LocalDate createdAtTo;

}