package com.isystk.sample.web.front.controller.html.entry.remind;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class EntryRemindForm implements Serializable {

	private static final long serialVersionUID = 7593564324192730932L;

	/** メールアドレス */
	@NotBlank
	@Email
	@Size(max = 100)
	String email;

}
