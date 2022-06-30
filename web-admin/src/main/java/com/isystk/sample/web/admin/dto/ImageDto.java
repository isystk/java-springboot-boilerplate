package com.isystk.sample.web.admin.dto;

import com.isystk.sample.common.values.ImageType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDto {

  ImageType imageType;

  String imageName;
}