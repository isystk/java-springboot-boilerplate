package com.isystk.sample.web.admin.controller.html.system.mail;

import javax.validation.constraints.Digits;

import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.web.base.controller.html.BaseSearchForm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SystemMailSearchForm extends BaseSearchForm implements Pageable {

  private static final long serialVersionUID = 7593564324192730932L;

  @Digits(integer = 9, fraction = 0)
  Integer templateDiv;

}
