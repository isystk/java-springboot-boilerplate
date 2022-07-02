package com.isystk.sample.web.admin.controller.html.user;

import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.web.base.controller.html.BaseSearchForm;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Setter
@Getter
public class UserListForm extends BaseSearchForm implements Pageable {

  private static final long serialVersionUID = 7593564324192730932L;

  String name;

  String email;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  LocalDate createdAtFrom;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  LocalDate createdAtTo;

}
