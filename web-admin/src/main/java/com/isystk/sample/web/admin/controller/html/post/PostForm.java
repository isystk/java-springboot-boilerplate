package com.isystk.sample.web.admin.controller.html.post;

import javax.validation.constraints.NotEmpty;

import com.isystk.sample.web.base.controller.html.BaseForm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostForm extends BaseForm {

    private static final long serialVersionUID = 7593564324192730932L;

    @NotEmpty
    Long postId;

    @NotEmpty
    Long userId;

    @NotEmpty
    String title;

    @NotEmpty
    String text;

	@Override
	public Long getId() {
		return postId;
	}

}
