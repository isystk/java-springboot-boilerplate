package com.isystk.sample.web.front.controller.api.v1.contact;

import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.web.base.controller.html.BaseSearchForm;
import java.math.BigInteger;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Setter
@Getter
public class ContactRestForm extends BaseSearchForm implements Pageable {

  private static final long serialVersionUID = 7593564324192730932L;

  @NotNull
  BigInteger contactId;

  @NotBlank
  String yourName;

  @NotBlank
  String email;

  @NotBlank
  @NumberFormat
  String gender;

  @NotBlank
  @NumberFormat
  String age;

  @NotBlank
  String title;

  @NotBlank
  String contact;

  @NotBlank
  String url;

  @NotBlank
  String contactImageName;

  @NotBlank
  String contactImageData;

}
