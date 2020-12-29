package com.isystk.sample.web.front.controller.api.v1.member.post;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Setter
@Getter
public class MemberPostDetailImageRestForm implements Serializable {

  @Digits(integer = 9, fraction = 0)
  Integer imageId;

}
