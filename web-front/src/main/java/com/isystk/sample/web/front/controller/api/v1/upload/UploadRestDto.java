package com.isystk.sample.web.front.controller.api.v1.upload;

import com.isystk.sample.common.dto.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadRestDto implements Dto {

	Integer imageId;

	Integer imagePath;

}
