package com.isystk.sample.web.front.controller.api.v1.post;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostRestForm implements Serializable {

	private static final long serialVersionUID = 7593564324192730932L;

	String title;

	String text;

}
