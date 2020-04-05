package com.isystk.sample.web.front.controller.html.member;

import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.web.base.controller.html.BaseSearchForm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberForm extends BaseSearchForm implements Pageable {

	private static final long serialVersionUID = 7593564324192730932L;

	Integer postId;

}
