package com.isystk.sample.web.admin.controller.html.stocks.edit;

import com.isystk.sample.web.base.controller.html.BaseForm;
import java.math.BigInteger;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Setter
@Getter
public class StocksEditForm extends BaseForm {

  private static final long serialVersionUID = 7593564324192730932L;

  @NotNull
  BigInteger stockId;

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
