package com.isystk.sample.web.admin.controller.html.stocks.regist;

import com.isystk.sample.web.base.controller.html.BaseForm;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Setter
@Getter
public class StocksRegistForm extends BaseForm {

  private static final long serialVersionUID = 7593564324192730932L;

  @NotBlank
  String name;

  @NotBlank
  String detail;

  @NotBlank
  @NumberFormat
  String price;

  @NotBlank
  @NumberFormat
  String quantity;

  @NotBlank
  String stockImageName;

  @NotBlank
  String stockImageData;

}
