package com.isystk.sample.domain.dto;

import com.isystk.sample.domain.entity.ContactFormImage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactFormImageRepositoryDto extends ContactFormImage {

  String contactImageName;

  String contactImageData;
}