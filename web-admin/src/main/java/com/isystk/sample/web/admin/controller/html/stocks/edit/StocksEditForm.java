package com.isystk.sample.web.admin.controller.html.stocks.edit;

import com.isystk.sample.web.base.controller.html.BaseForm;
import java.math.BigInteger;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StocksEditForm extends BaseForm {

  private static final long serialVersionUID = 7593564324192730932L;

  @NotNull
  BigInteger userId;

  @NotNull
  BigInteger stockId;

  @NotBlank
  String name;

  @NotBlank
  String price;

}
