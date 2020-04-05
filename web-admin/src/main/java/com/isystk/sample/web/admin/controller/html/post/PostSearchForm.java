package com.isystk.sample.web.admin.controller.html.post;

import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.web.base.controller.html.BaseForm;
import com.isystk.sample.web.base.controller.html.BaseSearchForm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostSearchForm extends BaseSearchForm implements Pageable {

	private static final long serialVersionUID = 7593564324192730932L;

	@Digits(integer = 9, fraction = 0)
	Integer postId;

	@Digits(integer = 9, fraction = 0)
	Integer userId;

	String title;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate registDateFrom;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate registDateTo;

}
