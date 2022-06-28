package com.isystk.sample.web.admin.controller.html.stocks.regist;

import com.isystk.sample.web.base.controller.html.BaseForm;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StocksRegistForm extends BaseForm {

  private static final long serialVersionUID = 7593564324192730932L;

  @NotBlank
  String name;

  @NotBlank
  String detail;

  @NotBlank
  String price;

  @NotBlank
  String quantity;

  @NotBlank
  String imgpath;

}
