package com.isystk.sample.web.front.controller.api.v1.contact;

import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.web.base.controller.html.BaseSearchForm;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Setter
@Getter
public class ContactForm extends BaseSearchForm implements Pageable {

  private static final long serialVersionUID = 7593564324192730932L;

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

  String url;

  @NotBlank
  String contactImageName;

  @NotBlank
  String contactImageData;

}
