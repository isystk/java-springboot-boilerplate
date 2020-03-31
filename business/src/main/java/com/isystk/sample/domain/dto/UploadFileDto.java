package com.isystk.sample.domain.dto;

import com.isystk.sample.domain.dto.common.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadFileDto implements Dto {

    Integer id;

    String path;

}
