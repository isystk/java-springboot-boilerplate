package com.isystk.sample.web.admin.api.v1.upload;

import com.isystk.sample.common.dto.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadRestDto implements Dto {

  Integer imageId;

  Integer imagePath;

}
