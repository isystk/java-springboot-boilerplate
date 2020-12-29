package com.isystk.sample.web.base.controller.html;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class BaseForm implements Serializable {

  // 改定番号
  Integer version;

}
