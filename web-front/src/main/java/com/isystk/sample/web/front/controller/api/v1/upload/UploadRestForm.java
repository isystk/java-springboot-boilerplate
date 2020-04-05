package com.isystk.sample.web.front.controller.api.v1.upload;

import org.springframework.web.multipart.MultipartFile;

import com.isystk.sample.web.base.controller.html.BaseForm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadRestForm extends BaseForm {

	private static final long serialVersionUID = 7593564324192730932L;

	Integer imageId;

	MultipartFile imageFile;

}
