package com.isystk.sample.common.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadFileDto implements Dto {

  Integer imageId;

  String imageUrlSquare;

  String imageUrlSd;

}
