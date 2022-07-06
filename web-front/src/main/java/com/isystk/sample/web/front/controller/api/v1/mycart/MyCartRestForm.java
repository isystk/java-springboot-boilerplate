package com.isystk.sample.web.front.controller.api.v1.mycart;

import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.web.base.controller.html.BaseSearchForm;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MyCartRestForm extends BaseSearchForm implements Pageable {

  private static final long serialVersionUID = 7593564324192730932L;

}
