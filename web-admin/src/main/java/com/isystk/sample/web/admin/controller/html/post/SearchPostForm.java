package com.isystk.sample.web.admin.controller.html.post;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.web.base.controller.html.BaseForm;
import com.isystk.sample.web.base.controller.html.BaseSearchForm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchPostForm extends BaseSearchForm implements Pageable {

    private static final long serialVersionUID = 7593564324192730932L;

    Integer postId;

    Integer userId;

    String title;

	@Override
	public Integer getId() {
		return postId;
	}

}
