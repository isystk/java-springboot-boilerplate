package com.isystk.sample.web.front.controller.api.v1.member.post;

import com.isystk.sample.web.base.controller.html.BaseForm;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
public class MemberPostRegistRestForm extends BaseForm {

  private static final long serialVersionUID = 1L;

  @NotEmpty
  String title;

  @NotEmpty
  String text;

  @Valid
  List<MemberPostDetailImageRestForm> imageList;

  @Valid
  List<MemberPostDetailTagRestForm> tagList;

}
